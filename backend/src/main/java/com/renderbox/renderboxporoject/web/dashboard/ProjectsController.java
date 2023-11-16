package com.renderbox.renderboxporoject.web.dashboard;

import com.renderbox.renderboxporoject.entity.Photo;
import com.renderbox.renderboxporoject.entity.Project;
import com.renderbox.renderboxporoject.entity.Service;
import com.renderbox.renderboxporoject.repository.PhotoRepository;
import com.renderbox.renderboxporoject.repository.ProjectRepository;
import com.renderbox.renderboxporoject.repository.ServiceRepository;
import com.renderbox.renderboxporoject.service.FileStorageService;
import com.renderbox.renderboxporoject.service.ThemeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProjectsController {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ThemeService themeService;
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private PhotoRepository photoRepository;

    @GetMapping("/dashboard/projects")
    public String search(Model model,
                         @RequestParam(name="projectName", defaultValue="") String projectName,
                         @RequestParam(name="page", defaultValue="0") int page,
                         @RequestParam(name="size", defaultValue="10") int size
    ) {
        Page<Project> projectPage = projectRepository.search("%"+projectName+"%", PageRequest.of(page,size));
        List<Project> projectList = projectPage.getContent();
        int[] pages = new int[projectPage.getTotalPages()];
        model.addAttribute("projectList", projectList);
        model.addAttribute("activePage", "Projects");
        model.addAttribute("pages", pages);
        model.addAttribute("size",size);
        model.addAttribute("pageCurrent", page);
        model.addAttribute("projectName", projectName);
        model.addAttribute("theme", themeService.getCurrentTheme());
        return "projects/search";
    }

    @GetMapping("/dashboard/create-project")
    public String create(Model model) {
        if(!model.containsAttribute("project"))
            model.addAttribute("project", new Project());
        List<Service> serviceList = serviceRepository.findAll();
        model.addAttribute("activePage", "Projects");
        model.addAttribute("serviceList", serviceList);
        model.addAttribute("theme", themeService.getCurrentTheme());
        return "projects/create";
    }

    @PostMapping("/dashboard/create-project")
    public String processCreate(@Valid Project project, BindingResult bindingResult, RedirectAttributes redirectAttrs, @RequestParam("serviceId") Long id, @RequestParam("projectPhotos") MultipartFile[] projectPhotos) throws IOException {
        if(bindingResult.hasErrors()) {
            redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.project", bindingResult);
            redirectAttrs.addFlashAttribute("project", project);
            return "redirect:/dashboard/create-project";
        }
        Service service =  serviceRepository.getById(id);
        project.setService(service);
        Project savedProject = projectRepository.save(project);

        if (!projectPhotos[0].isEmpty()) {
            if (savedProject.getPhotos() == null) {
                savedProject.setPhotos(new ArrayList<>());
            }
            for (MultipartFile projectPhoto: projectPhotos) {
                // Handle file upload logic using the FileStorageService
                String photoUrl = fileStorageService.storeFile(projectPhoto);

                // Create a Photo entity with the file URL and associate it with the project
                Photo photo = new Photo();
                photo.setProject(savedProject);
                photo.setPhotoUrl(photoUrl);
                Photo savedPhoto = photoRepository.save(photo);
                savedProject.getPhotos().add(savedPhoto);
            }
            projectRepository.save(savedProject);
        }

        redirectAttrs.addFlashAttribute("successMessage", "Project : " + project.getProjectName() +" created successfully");
        return "redirect:/dashboard/create-project";
    }

    @GetMapping("/dashboard/update-project")
    public String update(Model model, @RequestParam(name = "projectId") Long id) {
        if(!model.containsAttribute("project")) {
            Project project = projectRepository.getById(id);
            model.addAttribute("project", project);
        }
        List<Service> serviceList = serviceRepository.findAll();
        model.addAttribute("activePage", "Projects");
        model.addAttribute("serviceList", serviceList);
        model.addAttribute("theme", themeService.getCurrentTheme());
        return "projects/update";
    }

    @PostMapping("/dashboard/update-project")
    public String processUpdate(@Valid Project project, BindingResult bindingResult, RedirectAttributes redirectAttrs, @RequestParam("serviceId") Long id, @RequestParam(value = "projectPhotos", required = false) MultipartFile[] projectPhotos) throws IOException {
        if(bindingResult.hasErrors()) {
            redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.project", bindingResult);
            redirectAttrs.addFlashAttribute("project", project);
            return "redirect:/dashboard/update-project";
        }
        project.setService(serviceRepository.getById(id));
        if (!projectPhotos[0].isEmpty()) {
            if (project.getPhotos() == null) {
                project.setPhotos(new ArrayList<>());
            }
            for (MultipartFile projectPhoto: projectPhotos) {
                // Handle file upload logic using the FileStorageService
                String photoUrl = fileStorageService.storeFile(projectPhoto);

                // Create a Photo entity with the file URL and associate it with the project
                Photo photo = new Photo();
                photo.setProject(project);
                photo.setPhotoUrl(photoUrl);
                Photo savedPhoto = photoRepository.save(photo);
                project.getPhotos().add(savedPhoto);
            }
        }
        projectRepository.save(project);
        redirectAttrs.addFlashAttribute("successMessage", "Project : " + project.getProjectName() +" updated successfully");
        return "redirect:/dashboard/update-project?projectId="+project.getId();
    }

    @GetMapping("/dashboard/delete-project")
    public String processUpdate(@RequestParam("projectId") Long id,
                                RedirectAttributes redirectAttrs,
                                @RequestParam(name="page", defaultValue="0") int page,
                                @RequestParam(name="size", defaultValue="5") int size,
                                Model model) {
        projectRepository.deleteById(id);
        redirectAttrs.addFlashAttribute("successMessage", "project deleted successfully");
        return "redirect:/dashboard/projects?page="+page+"&size="+size;
    }
}
