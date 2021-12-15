package service.impl;

import bean.BenhAn;
import bean.BenhNhan;
import bean.DanhSachBenhAn;
import repository.IDanhSachBenhAnRepository;
import repository.impl.DanhSachBenhAnRepositoryImpl;
import service.IDanhSachBenhAnService;
import util.Validate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DanhSachBenhAnServiceImpl implements IDanhSachBenhAnService {


    IDanhSachBenhAnRepository iDanhSachBenhAnRepository = new DanhSachBenhAnRepositoryImpl();

    @Override
    public List<DanhSachBenhAn> findAll() {
        return iDanhSachBenhAnRepository.findAll();
    }

    @Override
    public Map<String, String> save(DanhSachBenhAn danhSachBenhAn) {
        return iDanhSachBenhAnRepository.save(danhSachBenhAn);
    }

    @Override
    public void remove(int id) {
        iDanhSachBenhAnRepository.remove(id);
    }

    @Override
    public DanhSachBenhAn findById(int id) {
        return iDanhSachBenhAnRepository.findById(id);
    }

    @Override
    public Map<String, String> update(DanhSachBenhAn danhSachBenhAn) {
        return iDanhSachBenhAnRepository.update(danhSachBenhAn);
    }

    @Override
    public List<DanhSachBenhAn> findByName(String name) {
        return iDanhSachBenhAnRepository.findByName(name);
    }

    @Override
    public List<BenhAn> findAllBenhAn() {
        return iDanhSachBenhAnRepository.findAllBenhAn();
    }

    @Override
    public List<BenhNhan> findAllBenhNhan() {
        return iDanhSachBenhAnRepository.findAllBenhNhan();
    }

//    @Override
//    public List<BenhAn> findAll() {
//        return iDanhSachBenhAnRepository.findAll();
//    }
//
//    @Override
//    public Map<String,String> save(BenhAn benhAn) {
//        Map<String,String> messageList = new HashMap<>();
//        Map<String,String> messageListRepo = this.iDanhSachBenhAnRepository.save(benhAn);
//        if (!messageListRepo.isEmpty()){
//            messageList.put("message",messageListRepo.get("message"));
//        }
//        if (!Validate.validateName(benhAn.getName())){
//            messageList.put("messageName","Invalid Name ex: Nguyen Văn A ");
//        }
//        if (benhAn.getAge()>100 || benhAn.getAge()<0){
//            messageList.put("messageAge","Invalid Age age from 1-100");
//        }
//        if (benhAn.getAverage()>10 || benhAn.getAverage()<0){
//            messageList.put("messageAverage","Invalid Average average from 1-10");
//        }
//        return messageList;
//    }
//
//    @Override
//    public void remove(int id) {
//        iDanhSachBenhAnRepository.remove(id);
//    }
//
//    @Override
//    public BenhAn findById(int id) {
//        return iDanhSachBenhAnRepository.findById(id);
//    }
//
//    @Override
//    public Map<String,String> update(BenhAn benhAn) {
//        Map<String,String> messageList = new HashMap<>();
//        Map<String,String> messageListRepo = iDanhSachBenhAnRepository.update(benhAn);
//
//        if (!messageListRepo.isEmpty()){
//            messageList.put("message",messageListRepo.get("message"));
//        }
//        if (!Validate.validateName(benhAn.getName())){
//            messageList.put("messageName","Invalid Name ex: Nguyen Văn A ");
//        }
//        if (benhAn.getAge()>100 || benhAn.getAge()<0){
//            messageList.put("messageAge","Invalid Age age from 1-100");
//        }
//        if (benhAn.getAverage()>10 || benhAn.getAverage()<0){
//            messageList.put("messageAverage","Invalid Average average from 1-10");
//        }
//
//        return messageList;
//    }
//
//    @Override
//    public List<BenhAn> findByName(String name) {
//        return iDanhSachBenhAnRepository.findByName(name);
//    }
//
//    @Override
//    public List<BenhAn> sortByAverage() {
//        return iDanhSachBenhAnRepository.sortByAverage();
//    }
//
//    @Override
//    public List<BenhAn> findTwoElement(String name, int id) {
//        return this.iDanhSachBenhAnRepository.findTwoElement(name,id);
//    }
//
//    @Override
//    public List<BenhNhan> findAllClass() {
//        return iDanhSachBenhAnRepository.findAllClass();
//    }

}
