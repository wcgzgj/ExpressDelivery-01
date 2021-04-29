package top.faroz.dao;

import top.faroz.pojo.Package;

import java.util.List;

/**
 * @ClassName PackageDao
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/4/28 下午8:29
 * @Version 1.0
 **/
public interface PackageDao {
    Package selectByCode(Integer code);
    Package deleteByCode(Integer code);
    Integer getEmptyLocation();
    boolean putPackage(Package newPackage);
    List<Package> selectAll();
    Package selectById(String id);
    Package deleteById(String id);
    void update(Package newPackage);
}
