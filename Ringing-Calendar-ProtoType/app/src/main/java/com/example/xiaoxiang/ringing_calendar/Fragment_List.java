package com.example.xiaoxiang.ringing_calendar;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;


public class Fragment_List extends ListFragment {


    private static final String SEARCHES = "searches";

    private goToWeb mListener;

    private ArrayList<String> tags;
    private ArrayAdapter<String> adapter;



    public Fragment_List() {

        tags = new ArrayList<String>();
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mListener.openSearch(tags.get(position));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, tags);
        setListAdapter(adapter);
        View view =  inflater.inflate(R.layout.fragment_fragment__list, container, false);



        return view;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (goToWeb) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }


    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface goToWeb {

        public void openSearch(String tag);
    }


    public void addTag(String tag){


        if (!tags.contains(tag))
        {
            tags.add(tag);
            Collections.sort(tags, String.CASE_INSENSITIVE_ORDER);
            adapter.notifyDataSetChanged(); // rebind tags to ListView
        }
    }








    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view,
                                int position, long id)
        {

            mListener.openSearch(tags.get(position));

        }
    }; // end itemClickListener declaration
}
