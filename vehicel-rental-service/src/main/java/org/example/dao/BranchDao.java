package org.example.dao;

import org.example.models.Branch;

import java.util.ArrayList;
import java.util.List;

public class BranchDao {
    private List<Branch> branches;
    private static BranchDao branchDao;

    private BranchDao() {
        branches = new ArrayList<>();
    }

    public static BranchDao getInstance() {
        if (branchDao == null) {
            branchDao = new BranchDao();
        }
        return branchDao;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }
}
