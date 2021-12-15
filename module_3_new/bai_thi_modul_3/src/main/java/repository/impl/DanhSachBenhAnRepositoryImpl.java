package repository.impl;

import bean.BenhAn;
import bean.BenhNhan;
import bean.DanhSachBenhAn;
import repository.IDanhSachBenhAnRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DanhSachBenhAnRepositoryImpl implements IDanhSachBenhAnRepository {
    @Override
    public List<DanhSachBenhAn> findAll() {
        List<DanhSachBenhAn> danhSachBenhAnList = new ArrayList<>();

        try {
            Statement statement = BaseRepository.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from danh_sach_benh_an");
            DanhSachBenhAn danhSachBenhAn = null;
            BenhNhan benhNhan = null;
            BenhAn benhAn = null;
            while (resultSet.next()) {
                benhAn = new BenhAn();
                benhNhan = new BenhNhan();
                danhSachBenhAn = new DanhSachBenhAn();

                danhSachBenhAn.setId(Integer.parseInt(resultSet.getString("id_danh_sach_benh_an")));
                danhSachBenhAn.setTenBenhNhan(resultSet.getString("ten_benh_nhan"));
                danhSachBenhAn.setNgayNhapVien(resultSet.getString("ngay_mhap_vien"));
                danhSachBenhAn.setNgayRaVien(resultSet.getString("ngay_ra_vien"));
                danhSachBenhAn.setLyDo(resultSet.getString("ly_do_nhap_vien"));
                benhAn.setId(resultSet.getString("id_ma_benh_an"));
                danhSachBenhAn.setIdBenhAn(benhAn);
                benhNhan.setId(resultSet.getString("id_ma_benh_nhan"));
                danhSachBenhAn.setIdBenhNhan(benhNhan);
                danhSachBenhAnList.add(danhSachBenhAn);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return danhSachBenhAnList;
    }

    @Override
    public Map<String, String> save(DanhSachBenhAn danhSachBenhAn) {
        return null;
    }

    @Override
    public void remove(int id) {
        try {
            PreparedStatement preparedStatement =
                    BaseRepository.connection.prepareStatement("delete from danh_sach_benh_an where id_danh_sach_benh_an=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public DanhSachBenhAn findById(int id) {
        DanhSachBenhAn danhSachBenhAn = null;
        BenhNhan benhNhan = null;
        BenhAn benhAn = null;
        try {
            PreparedStatement preparedStatement =
                    BaseRepository.connection.prepareStatement("select * from danh_sach_benh_an where id_danh_sach_benh_an=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                benhAn = new BenhAn();
                benhNhan = new BenhNhan();
                danhSachBenhAn = new DanhSachBenhAn();

                danhSachBenhAn.setId(Integer.parseInt(resultSet.getString("id_danh_sach_benh_an")));
                danhSachBenhAn.setTenBenhNhan(resultSet.getString("ten_benh_nhan"));
                danhSachBenhAn.setNgayNhapVien(resultSet.getString("ngay_mhap_vien"));
                danhSachBenhAn.setNgayRaVien(resultSet.getString("ngay_ra_vien"));
                danhSachBenhAn.setLyDo(resultSet.getString("ly_do_nhap_vien"));
                benhAn.setId(resultSet.getString("id_ma_benh_an"));
                danhSachBenhAn.setIdBenhAn(benhAn);
                benhNhan.setId(resultSet.getString("id_ma_benh_nhan"));
                danhSachBenhAn.setIdBenhNhan(benhNhan);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return danhSachBenhAn;
    }

    @Override
    public Map<String, String> update(DanhSachBenhAn danhSachBenhAn) {
        Map<String, String> messageList = new HashMap<>();

        try {
            PreparedStatement preparedStatement =
                    BaseRepository.connection.prepareStatement("update danh_sach_benh_an set id_ma_benh_an=?,id_ma_benh_nhan=?,ten_benh_nhan=?,ngay_mhap_vien=?,ngay_ra_vien=?,ngay_ra_vien=?,ly_do_nhap_vien where id_danh_sach_benh_an=?");

            preparedStatement.setString(1, danhSachBenhAn.getIdBenhAn().getId());
            preparedStatement.setString(2, danhSachBenhAn.getIdBenhNhan().getId());
            preparedStatement.setString(3, danhSachBenhAn.getTenBenhNhan());
            preparedStatement.setString(4, danhSachBenhAn.getNgayNhapVien());
            preparedStatement.setString(5, danhSachBenhAn.getNgayRaVien());
            preparedStatement.setString(6, danhSachBenhAn.getLyDo());
            preparedStatement.setInt(7, danhSachBenhAn.getId());

            preparedStatement.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            messageList.put("message", "invalid class id");
            return messageList;
        }
        return messageList;
    }

    @Override
    public List<DanhSachBenhAn> findByName(String name) {
        return null;
    }

    @Override
    public List<BenhAn> findAllBenhAn() {
        List<BenhAn> benhAnList = new ArrayList<>();
        try {
            Statement statement = BaseRepository.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from benh_an");
            BenhAn benhAn = null;
            while (resultSet.next()) {
                benhAn = new BenhAn();
                benhAn.setId(resultSet.getString("id_ma_benh_an"));
                benhAn.setTenBenhAn(resultSet.getString("ten_benh_an"));
                benhAnList.add(benhAn);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return benhAnList;
    }

    @Override
    public List<BenhNhan> findAllBenhNhan() {
        List<BenhNhan> benhNhanList = new ArrayList<>();
        try {
            Statement statement = BaseRepository.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from benh_nhan");
            BenhNhan benhNhan = null;
            while (resultSet.next()) {
                benhNhan = new BenhNhan();
                benhNhan.setId(resultSet.getString("id_ma_benh_nhan"));
                benhNhan.setTenBenh(resultSet.getString("ten_benh"));
                benhNhanList.add(benhNhan);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return benhNhanList;
    }
//
//    @Override
//    public List<DanhSachBenhAn> findAll() {
//        List<DanhSachBenhAn> danhSachBenhAnList = new ArrayList<>();
//
//        try {
//            Statement statement = BaseRepository.connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select * from danh_sach_benh_an");
//            DanhSachBenhAn danhSachBenhAn = null;
//            BenhNhan benhNhan = null;
//            BenhAn benhAn = null;
//            while (resultSet.next()) {
//                benhAn = new BenhAn();
//                benhNhan = new BenhNhan();
//                danhSachBenhAn = new DanhSachBenhAn();
//
//                danhSachBenhAn.setId(Integer.parseInt(resultSet.getString("id_danh_sach_benh_an")));
//                danhSachBenhAn.setTenBenhNhan(resultSet.getString("ten_benh_nhan"));
//                danhSachBenhAn.setNgayNhapVien(resultSet.getString("ngay_mhap_vien"));
//                danhSachBenhAn.setNgayRaVien(resultSet.getString("ngay_ra_vien"));
//                danhSachBenhAn.setLyDo(resultSet.getString("ly_do_nhap_vien"));
//
//                benhAn.setId(resultSet.getString("id_ma_benh_an"));
//                danhSachBenhAn.setIdBenhAn(benhAn);
//                benhNhan.setId(resultSet.getString("id_ma_benh_nhan"));
//                danhSachBenhAn.setIdBenhNhan(benhNhan);
//                danhSachBenhAnList.add(danhSachBenhAn);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        return danhSachBenhAnList;
//    }



}
