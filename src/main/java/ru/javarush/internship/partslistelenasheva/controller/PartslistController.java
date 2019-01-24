package ru.javarush.internship.partslistelenasheva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.javarush.internship.partslistelenasheva.entity.PartEntity;
import ru.javarush.internship.partslistelenasheva.service.PartServiceImp;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PartslistController {

    private static final int COUNT_OF_PAGE_SIZE = 10;

    @Autowired
    private PartServiceImp fPartService;

    private Integer getMinCountComputer() {
        return fPartService.getMinCountComputer();
    }

    @RequestMapping(value="/",method = RequestMethod.GET)
    public ModelAndView index(@RequestParam(required = false) Integer page) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("part", new PartEntity());
        List<PartEntity> parts = fPartService.findAllParts();
        PagedListHolder<PartEntity> pagedListHolder = new PagedListHolder<>(parts);
        pagedListHolder.setPageSize(COUNT_OF_PAGE_SIZE);
        modelAndView.addObject("maxPages", pagedListHolder.getPageCount());

        if(page == null || page < 1 || page > pagedListHolder.getPageCount())
            page = 1;

        modelAndView.addObject("number", page);

        if(page > pagedListHolder.getPageCount()){
            pagedListHolder.setPage(page);
            modelAndView.addObject("listParts", pagedListHolder.getPageList());
        }

        else if(page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page - 1);
            modelAndView.addObject("listParts", pagedListHolder.getPageList());
        }

        Integer lMinCountOfComputer = getMinCountComputer();
        modelAndView.addObject("minCountOfComputer", lMinCountOfComputer);
        return modelAndView;
    }

    @RequestMapping(value = { "/sort" }, method = RequestMethod.GET)
    public ModelAndView sortPartList(@RequestParam(required = false) String param) {
        ModelAndView model = new ModelAndView("sort");
        List<PartEntity> lPartsList = null;
        if ("NECESSARY".equalsIgnoreCase(param)){
            model.addObject("sortParam", "Sort of Partslist: Necessary");
            lPartsList = fPartService.findAllNecessary();
        } else if ("OPTIONAL".equalsIgnoreCase(param)){
            model.addObject("sortParam", "Sort of Partslist: Optional");
            lPartsList = fPartService.findAllOptional();
        } else {
            model.addObject("sortParam", "Sort of Partslist: All");
            lPartsList = fPartService.findAllParts();
        }
        model.addObject("partsList", lPartsList);
        return model;
    }

    @RequestMapping(value = { "/search" }, method = RequestMethod.GET)
    public ModelAndView searchPart(@RequestParam(required = false) String name) {
        ModelAndView model = new ModelAndView("search");
        List<PartEntity> lPartsList = null;
        if (name != null && name.length() > 0){
            lPartsList = fPartService.findListPartEntityByPartNameContains(name);
        } else {
            lPartsList = new ArrayList<>();
        }
        model.addObject("partsList", lPartsList);
        return model;
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam String name,
                             @RequestParam Integer quantity,
                             @RequestParam(value = "necessary", required = false) boolean isNecessary) {

        if (name != null && name.length() > 0){
            if (fPartService.isPartnameUnique(null, name)){
                PartEntity lNewEntity = new PartEntity();
                lNewEntity.setPartName(name);
                lNewEntity.setNecessary(isNecessary);
                lNewEntity.setQuantity(quantity);

                fPartService.savePart(lNewEntity);

                return "redirect:/";
            }
        }
        return "addPart";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        fPartService.deletePart(id);
        return "redirect:/";
    }

    @GetMapping("/addPart")
    public String addProduct() {
        return "addPart";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editProduct(@PathVariable Integer id) {
        ModelAndView model = new ModelAndView("editPart");
        PartEntity lPartEntity = fPartService.findPartById(id);
        model.addObject("part", lPartEntity);
        return model;
    }

    @PostMapping("/update")
    public String editProduct(@RequestParam Integer id,
                              @RequestParam String name,
                             @RequestParam Integer quantity,
                             @RequestParam(value = "necessary", required = false) boolean isNecessary) {

        if (name != null && name.length() > 0){
            if (fPartService.isPartnameUnique(id, name)){
                PartEntity lEntity = fPartService.findPartById(id);
                lEntity.setPartName(name);
                lEntity.setNecessary(isNecessary);
                lEntity.setQuantity(quantity);

                fPartService.savePart(lEntity);
                return "redirect:/";
            }
        }
        return "redirect:/edit/" + id;
    }

}
