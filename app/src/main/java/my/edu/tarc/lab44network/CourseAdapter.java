package my.edu.tarc.lab44network;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by TARC on 8/6/2015.
 */
public class CourseAdapter extends ArrayAdapter<Course> {

    public CourseAdapter(Activity context, int resource, List<Course> list) {
        //context = the host activity
        //resource = the layout in the host activity
        //list = a list of course record
        super(context, resource, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //position = index of a record
        //convert view = layout for each record
        //parent = layout hosting the record
        Course course = getItem(position);

        LayoutInflater inflater  = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.course_record, parent, false);

        TextView textViewCode, textViewTitle, textViewCredit;

        textViewCode = rowView.findViewById(R.id.textViewCode);
        textViewTitle = rowView.findViewById(R.id.textViewTitle);
        textViewCredit = rowView.findViewById(R.id.textViewCredit);

        //getContext = getting the current activity
        textViewCode.setText(String.format("%s : %s",getContext().getString(R.string.code),course.getCode()));
        textViewTitle.setText(String.format("%s : %s",getContext().getString(R.string.title),course.getTitle()));
        textViewCredit.setText(String.format("%s : %s",getContext().getString(R.string.credit),course.getCredit()));
        return rowView;
    }
}