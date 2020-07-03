package service.impl;

import dao.impl.SignDaoImpl;
import entity.Sign;
import service.SignService;

import java.util.ArrayList;
import java.util.List;

public class SignServiceImpl implements SignService {
    @Override
    public boolean insert(Sign sign) {
        String sql = "insert into sign(sign_number, "
                + "sign_name, sign_sex, sign_id_number,"
                + " sign_department, sign_site, sign_room, "
                + "sign_seat, sign_exam_number, sign_level, sign_subject, sign_phone, sign_pic)"
                + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        List<Object> list = new ArrayList<>();
        list.add(sign.getSignNumber());
        list.add(sign.getSignName());
        list.add(sign.getSignSex());
        list.add(sign.getSignIdNumber());
        list.add(sign.getSignDepartment());
        list.add(sign.getSignSite());
        list.add(sign.getSignRoom());
        list.add(sign.getSignSeat());
        list.add(sign.getSignExamNumber());
        list.add(sign.getSignLevel());
        list.add(sign.getSignSubject());
        list.add(sign.getSignPhone());
        list.add(sign.getSignPic());
        return new SignDaoImpl().doPstm(sql,list);
    }

    @Override
    public Sign select(String signNumber) {
        return new SignDaoImpl().select(signNumber);
    }

    @Override
    public List<Sign> findAll() {
        return new SignDaoImpl().findAll();
    }

    @Override
    public boolean delete(String signNumber) {
        String sql = "delete from sign where sign_number=?";
        List<Object> list = new ArrayList<>();
        list.add(signNumber);
        return new SignDaoImpl().doPstm(sql,list);
    }

    @Override
    public boolean update(Sign sign) {
        String sql = "update sign set sign_number = ?, sign_name = ?, sign_sex = ?, sign_id_number = ?, "
                + "sign_department = ?, sign_site = ?, sign_room = ?, sign_seat = ?, sign_exam_number = ?, "
                + "sign_level = ?, sign_subject = ?, sign_phone= ?, sign_pic = ? where id = ?";
        List<Object> list = new ArrayList<>();
        list.add(sign.getSignNumber());
        list.add(sign.getSignName());
        list.add(sign.getSignSex());
        list.add(sign.getSignIdNumber());
        list.add(sign.getSignDepartment());
        list.add(sign.getSignSite());
        list.add(sign.getSignRoom());
        list.add(sign.getSignSeat());
        list.add(sign.getSignExamNumber());
        list.add(sign.getSignLevel());
        list.add(sign.getSignSubject());
        list.add(sign.getSignPhone());
        list.add(sign.getSignPic());
        list.add(sign.getId());
        return new SignDaoImpl().doPstm(sql,list);
    }

    @Override
    public void confind(Sign sign) {
        new SignDaoImpl().confind(sign);
    }

    @Override
    public int selectLastId() {
        return new SignDaoImpl().selectLastId();
    }
}
