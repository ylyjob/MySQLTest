package com.nd.test;

import com.nd.domain.Sort;
import com.nd.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by you_lu_yao on 2017/8/18.
 */
public class JDBCDemo {
    public static void main(String[] args) throws SQLException {
        Connection con=JDBCUtils.getConnection();
        PreparedStatement pst=con.prepareStatement("SELECT * FROM sort");
        ResultSet rs=pst.executeQuery();
        List<Sort> list=new ArrayList<Sort>();
        while(rs.next()){
            //��ȡ��ÿ��������,��װ��Sort������
            Sort s = new Sort(rs.getInt("sid"),rs.getString("sname"),rs.getDouble("sprice"),rs.getString("sdesc"));
            //��װ��Sort����,�洢��������
            list.add(s);
        }
        JDBCUtils.close(con, pst, rs);
        //����List����
        for(Sort s : list){
            System.out.println(s);
        }
    }
}
