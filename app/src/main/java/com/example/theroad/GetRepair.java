package com.example.theroad;
import android.content.Context;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    public class GetRepair {

        public List<RepairCenter> getdata(Context cn)
        {

            Database db=new Database();
            db.ConnectDB();
            List<RepairCenter> data=new ArrayList<>();
            ResultSet rs=db.RunSearch("Select * from Repair_Center" );
            try{
                while (rs.next())
                {
                    RepairCenter r=new RepairCenter();
                    r.setRapiarid(rs.getString(1));
                    r.setRepairname(rs.getString(2));
                    r.setRepairlogo(rs.getString(5));
                    r.setRepairspecialty(rs.getString(7));
                    r.setRapiarphone(rs.getString(8));
                    data.add(r);
                }
            }catch (SQLException e){e.printStackTrace();
            }
            return  data;
        }
    }

