package com.shosha.springboot.demo.controller.instructorcontroller;

import com.shosha.springboot.demo.error.exception.SqlConstraintException;
import com.shosha.springboot.demo.model.dto.AddressDto;
import com.shosha.springboot.demo.model.dto.InstructorDto;
import com.shosha.springboot.demo.model.entity.Instructor;
import com.shosha.springboot.demo.service.instructorservice.InstructorService;
import com.shosha.springboot.demo.util.transformation.InstructorTransformation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String listInstructors(Model model) {
        List<Instructor> instructors = instructorService.findAllInstructors();
        model.addAttribute("instructors", instructors);
        return "list-instructors";
    }

    @GetMapping("/instructors/new")
    public String showInstructorForm(Model model) {
        model.addAttribute("instructor", new InstructorDto());
        return "instructors-form-add";
    }

    @PostMapping("/instructors/save")
    public String saveInstructor(@ModelAttribute InstructorDto instructorDto) throws SqlConstraintException {
        instructorService.save(instructorDto);
        return "redirect:/";
    }

    @GetMapping("/instructors/search")
    public String searchInstructor(@RequestParam String firstName, Model model) {
        List<Instructor> instructor = instructorService.findInstructorByFirstName(firstName);
        model.addAttribute("instructors", instructor);
        return "instructors-search-results";
    }

    @GetMapping("/instructors/edit/{id}")
    public String showUpdateInstructorForm(@PathVariable String id, Model model) {
        Instructor instructor = instructorService.findById(id);
        model.addAttribute("instructor", instructor);
        return "instructors-form-update";
    }

    @PostMapping("/instructors/update/{id}")
    public String updateInstructor(@PathVariable String id, @ModelAttribute Instructor instructor) throws SqlConstraintException {
        InstructorDto instructorDto = InstructorTransformation.transformToInstructorDto(instructor);
        instructorService.update(instructorDto, id);
        return "redirect:/";
    }

    @GetMapping("/instructors/{id}")
    public String getInstructor(@PathVariable String id, Model model) {
        Instructor instructor = instructorService.findById(id);
        InstructorDto instructorDto = instructorService.getInstructorDtoById(id);
        model.addAttribute("instructor", instructor);
        return "instructor-details";
    }

    @GetMapping("/instructors/getCourseCode")
    public String getCourseCodeOfTheInstructor(Model model) {
        model.addAttribute("instructorEmail", new InstructorDto());
        return "instructors-get-course-code";
    }

    @GetMapping("/instructors/courseCode")
    public String getCourseCodeOfTheInstructorWithEmail(@RequestParam String email, Model model) {
        Optional<Instructor> instructor = instructorService.findInstructorByEmail(email);
        if (instructor.isPresent()) {
            model.addAttribute("instructorDto",
                    InstructorTransformation.transformToInstructorDto(instructor.get()));
            return "instructor-course-code";
        } else
            return "redirect:/";
    }

    @GetMapping("/instructors/getAddress")
    public String getAddressOfTheInstructor(Model model) {
        model.addAttribute("instructorAddress", new InstructorDto());
        return "instructors-get-address";
    }

    @GetMapping("/instructors/address")
    public String getAddressOfTheInstructor(@RequestParam String email, Model model) {
        Optional<Instructor> instructor = instructorService.findInstructorByEmail(email);
        if (instructor.isPresent()) {
            model.addAttribute("instructorDto",
                    InstructorTransformation.transformToInstructorDto(instructor.get()));
            return "instructor-address";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/instructors/delete/{id}")
    public String deleteInstructorById(@PathVariable String id) {
        instructorService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/instructors/getCourse")
    public String getAddressByCourseName(Model model) {
        model.addAttribute("courseAddress", new InstructorDto());
        return "instructors-get-address-course-name";
    }

    @GetMapping("/instructors/course/address")
    public String getAddressByCourseName(@RequestParam String courseName, Model model) {
        AddressDto addressDto = instructorService.findAddressByCourseName(courseName);
        model.addAttribute("address", addressDto);
        return "course-address";
    }
    @GetMapping("/instructors/access-denied")
    public String accessDenied(){
        return "access-denied";
    }

}
