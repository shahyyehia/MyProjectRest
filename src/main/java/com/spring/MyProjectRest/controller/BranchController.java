package com.spring.MyProjectRest.controller;

import com.spring.MyProjectRest.entity.Branch;
import com.spring.MyProjectRest.service.Branch.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BranchController {

    BranchService branchService;

    @Autowired
    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping("/branches")
    public List<Branch> findAll(){
        return branchService.findAll();
    }

    @GetMapping("/branches/{id}")
    public Branch findById(@PathVariable int id){
        return branchService.findById(id);
    }

    @PostMapping ("/branches")
    public Branch addbranch(@RequestBody Branch branch){
        branch.setId(0);
        branchService.addBranch(branch);
        return branch;
    }
    @PutMapping ("/branches")
    public Branch updatebranch(@RequestBody Branch branch){
        branchService.addBranch(branch);
        return branch;
    }

    @DeleteMapping ("/branches/{id}")
    public String Deletebranch(@PathVariable int id){
        Branch branch=branchService.findById(id);
        if (branch==null){
            throw new RuntimeException("this branch doesn't exist");
        }
        else {
            branchService.delete(id);
        }
        return "deleted branch with id: "+id;
    }
}
