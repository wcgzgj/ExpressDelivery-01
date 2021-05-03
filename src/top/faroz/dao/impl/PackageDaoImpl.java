package top.faroz.dao.impl;

import top.faroz.dao.PackageDao;
import top.faroz.pojo.Package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName PackageDaoImpl
 * @Description Package的 Dao 层实现
 * @Author FARO_Z
 * @Date 2021/4/28 下午8:30
 * @Version 1.0
 **/
public class PackageDaoImpl implements PackageDao {

    //定义快递柜的大小为40
    private static int cabinetSize=40;

    /**
     * 因为没有数据库
     * 所以我在这里模拟数据库
     */

    //自定义快递柜
    private static Package[] cabinet= new Package[cabinetSize];


    @Override
    public Package selectByCode(Integer code) {
        for (int i = 0; i < 40; i++) {
            if (cabinet[i]!=null && cabinet[i].getGetCode().equals(code)) {
                return cabinet[i];
            }
        }
        return null;
    }

    @Override
    public Package deleteByCode(Integer code) {
        Package tmp=null;
        for (int i = 0; i < 40; i++) {
            if (cabinet[i]!=null && cabinet[i].getGetCode().equals(code)) {
                tmp = cabinet[i];
                cabinet[i]=null;
            }
        }
        return tmp;
    }

    @Override
    public Integer getEmptyLocation() {
        for (int i = 0; i < 40; i++) {
            if (cabinet[i]==null) {
                return i;
            }
        }
        //没有空位，返回-1
        return -1;
    }

    @Override
    public boolean putPackage(Package newPackage) {
        if (cabinet[newPackage.getLocation()]!=null) {
            return false;
        }
        cabinet[newPackage.getLocation()]=newPackage;
        return true;
    }

    /**
     * 获得 Package 库中所有的包裹信息
     * @return
     */
    @Override
    public List<Package> selectAll() {
        List<Package> list = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            if (cabinet[i]!=null) {
                Package daoPackage = cabinet[i];
                //public Package(Integer location, String id, String business, Integer getCode)
                list.add(new Package(daoPackage.getLocation(),
                        daoPackage.getId(),
                        daoPackage.getBusiness(),
                        daoPackage.getGetCode()));
            }
        }
        return list;
    }

    @Override
    public Package selectById(String id) {
        for (int i = 0; i < 40; i++) {
            if (cabinet[i]!=null && cabinet[i].getId().equals(id)) {
                return cabinet[i];
            }
        }
        return null;
    }

    @Override
    public Package deleteById(String id) {
        Package daoPackage=null;
        for (int i = 0; i < 40; i++) {
            if (cabinet[i]!=null && cabinet[i].getId().equals(id)) {
                daoPackage = cabinet[i];
                cabinet[i]=null;
            }
        }
        return daoPackage;
    }

    /**
     * 依据新传来的包裹信息，更新快递柜中的包裹
     * @param newPackage
     */
    @Override
    public void update(Package newPackage) {
        /**
         * 这里有点不合规范
         * 一般 ID 应该是用 雪花算法或者 UUID 生成的一个唯一值
         * 我这里却将 ID 作为 快递单号（而且是可以被修改的）
         *
         * 但是这里的快递柜数是不会改变的
         * 所有，这里我就将快递柜数作为一个临时的"ID"了
         */
        for (int i = 0; i < 40; i++) {
            if (cabinet[i]!=null && cabinet[i].getLocation().equals(newPackage.getLocation())) {
                cabinet[i].setId(newPackage.getId());
                cabinet[i].setBusiness(newPackage.getBusiness());
            }
        }
    }
}
