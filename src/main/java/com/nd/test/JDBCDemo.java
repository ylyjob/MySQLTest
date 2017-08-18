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
            //获取到每个列数据,封装到Sort对象中
            Sort s = new Sort(rs.getInt("sid"),rs.getString("sname"),rs.getDouble("sprice"),rs.getString("sdesc"));
            //封装的Sort对象,存储到集合中
            list.add(s);
        }
        JDBCUtils.close(con, pst, rs);
        //遍历List集合
        for(Sort s : list){
            System.out.println(s);
        }
    }
}
