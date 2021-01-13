package com.example.theroad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
public class AdapterRepair extends ArrayAdapter<RepairCenter> {
    Context context;
    ArrayList < RepairCenter > mCategoryList;
    public AdapterRepair(Context context , ArrayList <RepairCenter> mCategoryList){
        super(context,R.layout.layoutrepair,mCategoryList);
        this.context = context;
        this.mCategoryList =mCategoryList; }
    public class Holder
    { TextView txtname,txtno;
        ImageView imgFV;}
    public View getView(int position, View convertView, ViewGroup parent){
        RepairCenter  data = getItem(position);

        Holder viewHolder;

        if (convertView == null){ viewHolder = new Holder();
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.layoutrepair,parent ,false);
            viewHolder.txtno = (TextView) convertView.findViewById(R.id.txtrepairno);
            viewHolder.txtname = (TextView) convertView.findViewById(R.id.txtrepair);
            viewHolder.imgFV = (ImageView) convertView.findViewById(R.id.imgrepair);
            convertView.setTag(viewHolder); }
        else { viewHolder = (Holder) convertView.getTag();}
        viewHolder.txtno.setText(((RepairCenter) data).getRapiarid());
        viewHolder.txtname.setText(((RepairCenter) data).getRepairname());
        PicassoClinte.downloadImage(context,((RepairCenter) data).getRepairlogo(),viewHolder.imgFV);
        //  viewHolder.mImage
        return convertView; }}