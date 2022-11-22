package com.spring.MyProjectRest.service.Branch;

import com.spring.MyProjectRest.entity.Branch;
import com.spring.MyProjectRest.repo.BranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchServiceImplementation implements BranchService {

    BranchRepo repo;



    @Autowired
    public BranchServiceImplementation(BranchRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Branch> findAll() {

        return repo.findAll();
    }

    @Override
    public Branch findById(int id) {

        Optional<Branch> result = repo.findById(id);
        Branch Branch=null;
        if (result!=null){
            Branch=result.get();
        }
        else {
            throw new RuntimeException("Branch not found");
        }
        return Branch;
    }

    @Override
    public void addBranch(Branch Branch) {
        repo.save(Branch);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}
