package service;

import bean.BenhAn;
import bean.BenhNhan;
import bean.DanhSachBenhAn;

import java.util.List;
import java.util.Map;

public interface IDanhSachBenhAnService {

    List<DanhSachBenhAn> findAll();
    Map<String,String> save(DanhSachBenhAn danhSachBenhAn);
    void remove(int id);
    DanhSachBenhAn findById(int id);
    Map<String,String> update(DanhSachBenhAn danhSachBenhAn);
    List<DanhSachBenhAn> findByName(String name);

    List<BenhAn> findAllBenhAn();
    List<BenhNhan> findAllBenhNhan();
}
