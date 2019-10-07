package com.aaa.wisewordsinlife.Adapter;

import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.aaa.wisewordsinlife.R;
import com.aaa.wisewordsinlife.Activity.CourageAndStrengthDetailsActivity;
import com.aaa.wisewordsinlife.Interface.ImageClickTwo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AttitudeImgAdapter extends RecyclerView.Adapter<AttitudeImgAdapter.ContentView> {
    List<Integer> imgListTwo = new ArrayList<>();

    public AttitudeImgAdapter(List<Integer> imgListTwo) {
        this.imgListTwo = imgListTwo;
    }

    @Override
    public ContentView onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.attitudeimage_layout,parent,false );

        return new ContentView (view);
    }

    @Override
    public void onBindViewHolder(ContentView holder, int position) {

      /*  Picasso.get().load("https://pbs.twimg.com/profile_images/1016238879727333376/1vjjlvZ_400x400.jpg")
                .fit().centerCrop()
                .error(ima)
                .placeholder(imgListTwo.get(position))
                .into(holder.imageViewT);*/


        holder.imageViewT.setImageResource( imgListTwo.get( position ) );
        holder.setImageClickTwo( new ImageClickTwo() {
            @Override
            public void onClickTwo(View view, int position) {

                imgListTwo.get(position);
                Intent intent = new Intent( view.getContext(), CourageAndStrengthDetailsActivity.class );
                intent.putExtra( "PositionTwo",position );
                view.getContext().startActivity( intent );

            }
        } );


    }

    @Override
    public int getItemCount() {
        return imgListTwo.size();
    }

    public class ContentView extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageViewT;
        ImageClickTwo imageClickSecond;
        public ContentView(View itemView) {
            super( itemView );
            imageViewT = (ImageView)itemView.findViewById( R.id.imgVWT );
            itemView.setOnClickListener( this );
        }

        @Override
        public void onClick(View v) {
            this.imageClickSecond.onClickTwo( v,getLayoutPosition() );

        }

        public void setImageClickTwo(ImageClickTwo icT) {
            this.imageClickSecond = icT;

        }


    }
}
