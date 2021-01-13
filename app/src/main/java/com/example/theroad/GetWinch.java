package com.example.theroad;

import android.content.Context;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetWinch {

    public List<Winch> getdata(Context cn)
    {

        Database db=new Database();
        db.ConnectDB();
        List<Winch> data=new ArrayList<>();
        ResultSet rs=db.RunSearch("Select * from Winch" );
        try{
            while (rs.next())
            {
                Winch q=new Winch();
                q.setWinchid(rs.getString(1));
                q.setWinchname(rs.getString(2));
                q.setWinchLogo(rs.getString(4));
                q.setWinchPhone(rs.getString(3));
                data.add(q);
            }
        }catch (SQLException e){e.printStackTrace();
        }
        return data;
    }
}

