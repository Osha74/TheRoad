package com.example.theroad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class AdapterWinch extends ArrayAdapter<Winch> {
    Context context;
    ArrayList <Winch> mCategoryList;

    public AdapterWinch(Context context , ArrayList<Winch> mCategoryList){
        super(context,R.layout.layoutwinch,mCategoryList);
        this.context = context;
        this.mCategoryList =mCategoryList;
    }

    public class Holder {
        TextView txtname,txtno;
        ImageView imgFV;

    }

    public View getView(int position, View convertView, ViewGroup parent){
        Winch data = getItem(position);

        Holder viewHolder;

        if (convertView == null){

            viewHolder = new Holder();

            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.layoutwinch,parent ,false);

            viewHolder.txtno = (TextView) convertView.findViewById(R.id.txtwinchno);

            viewHolder.txtname = (TextView) convertView.findViewById(R.id.txtwinch);
            viewHolder.imgFV = (ImageView) convertView.findViewById(R.id.imgwinch);

            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (Holder) convertView.getTag();
        }

        viewHolder.txtno.setText(((Winch) data).getWinchid());
        viewHolder.txtname.setText(((Winch) data).getWinchname());
        PicassoClinte.downloadImage(context,((Winch) data).getWinchLogo(),viewHolder.imgFV);


      //  viewHolder.mImage

        return convertView;
    }




}
