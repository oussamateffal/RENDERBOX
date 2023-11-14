package com.renderbox.renderboxporoject.web.dashboard;

import com.renderbox.renderboxporoject.entity.Service;
import com.renderbox.renderboxporoject.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.cglib.core.Predicate;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class ServicesController {

    @Autowired
    private ServiceRepository serviceRepository;

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
        return "services/search";
    }
}
