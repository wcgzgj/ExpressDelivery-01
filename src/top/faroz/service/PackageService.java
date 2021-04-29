package top.faroz.service;

import top.faroz.pojo.Package;

import java.util.List;

public interface PackageService {
    Package getByCode(Integer code);
    Package deleteByCode(Integer code);
    Integer getEmptyLocation();
    boolean putPackage(Package newPackage);
    List<Package> getAllPackage();
    Package selectById(String id);
    Package deleteById(String id);
    void update(Package newPackage);
}
