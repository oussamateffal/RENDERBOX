package com.renderbox.renderboxporoject.web.dashboard;

import com.renderbox.renderboxporoject.entity.Service;
import com.renderbox.renderboxporoject.repository.ServiceRepository;
import com.renderbox.renderboxporoject.service.ThemeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.cglib.core.Predicate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
public class ServicesController {

    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private ThemeService themeService;

    @GetMapping("/dashboard/services")
    public String search(Model model,
                         @RequestParam(name="serviceName", defaultValue="") String serviceName,
                         @RequestParam(name="page", defaultValue="0") int page,
                         @RequestParam(name="size", defaultValue="10") int size
                         ) {
        Page<Service> servicePage = serviceRepository.search("%"+serviceName+"%", PageRequest.of(page,size));
        List<Service> serviceList = servicePage.getContent();
        int[] pages = new int[servicePage
                .getTotalPages()];
        model.addAttribute("serviceList", serviceList);
        model.addAttribute("activePage", "Services");
        model.addAttribute("pages", pages);
        model.addAttribute("size",size);
        model.addAttribute("pageCurrent", page);
        model.addAttribute("serviceName", serviceName);
        model.addAttribute("theme", themeService.getCurrentTheme());
        return "services/search";
    }

    @GetMapping("/dashboard/create-service")
    public String create(Model model) {
        if(!model.containsAttribute("service"))
            model.addAttribute("service", new Service());
        model.addAttribute("activePage", "Services");
        model.addAttribute("theme", themeService.getCurrentTheme());
        return "services/create";
    }

    @PostMapping("/dashboard/create-service")
    public String processCreate(@Valid Service service, BindingResult bindingResult, RedirectAttributes redirectAttrs, Model model) {
        if(bindingResult.hasErrors()) {
            redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.service", bindingResult);
            redirectAttrs.addFlashAttribute("service", service);
            return "redirect:/dashboard/create-service";
        }
        serviceRepository.save(service);
        redirectAttrs.addFlashAttribute("successMessage", "Service : " + service.getServiceName() +" created successfully");
        return "redirect:/dashboard/create-service";
    }

    @GetMapping("/dashboard/update-service")
    public String update(Model model, @RequestParam(name = "serviceId") Long id) {
        if(!model.containsAttribute("service")) {
            Service service = serviceRepository.getById(id);
            model.addAttribute("service", service);
        }
        model.addAttribute("activePage", "Services");
        model.addAttribute("theme", themeService.getCurrentTheme());
        return "services/update";
    }

    @PostMapping("/dashboard/update-service")
    public String processUpdate(@Valid Service service, BindingResult bindingResult, RedirectAttributes redirectAttrs, Model model) {
        if(bindingResult.hasErrors()) {
            redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.service", bindingResult);
            redirectAttrs.addFlashAttribute("service", service);
            return "redirect:/dashboard/update-service";
        }
        serviceRepository.save(service);
        redirectAttrs.addFlashAttribute("successMessage", "Service : " + service.getServiceName() +" updated successfully");
        return "redirect:/dashboard/update-service?serviceId="+service.getId();
    }

    @GetMapping("/dashboard/delete-service")
    public String processUpdate(@RequestParam("serviceId") Long id,
                                RedirectAttributes redirectAttrs,
                                @RequestParam(name="page", defaultValue="0") int page,
                                @RequestParam(name="size", defaultValue="5") int size,
                                Model model) {
        serviceRepository.deleteById(id);
        redirectAttrs.addFlashAttribute("successMessage", "Service deleted successfully");
        return "redirect:/dashboard/services?page="+page+"&size="+size;
    }
}
