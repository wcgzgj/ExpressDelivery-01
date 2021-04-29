package top.faroz.service.impl;

import top.faroz.dao.PackageDao;
import top.faroz.dao.impl.PackageDaoImpl;
import top.faroz.pojo.Package;
import top.faroz.service.PackageService;

import java.util.List;

/**
 * @ClassName PackageServiceImpl
 * @Description TODO
 * @Author FARO_Z
 * @Date 2021/4/28 下午8:30
 * @Version 1.0
 **/
public class PackageServiceImpl implements PackageService {

    private static PackageDao packageDao = new PackageDaoImpl();

    public PackageServiceImpl() {
    }

    @Override
    public Package getByCode(Integer code) {
        return packageDao.selectByCode(code);
    }

    @Override
    public Package deleteByCode(Integer code) {
        return packageDao.deleteByCode(code);
    }

    @Override
    public Integer getEmptyLocation() {
        return packageDao.getEmptyLocation();
    }

    @Override
    public boolean putPackage(Package newPackage) {
        return packageDao.putPackage(newPackage);
    }

    @Override
    public List<Package> getAllPackage() {
        return packageDao.selectAll();
    }

    @Override
    public Package selectById(String id) {
        return packageDao.selectById(id);
    }

    @Override
    public Package deleteById(String id) {
        return packageDao.deleteById(id);
    }

    @Override
    public void update(Package newPackage) {
        packageDao.update(newPackage);
    }
}
