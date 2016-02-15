package com.xiaoxin.acp_client.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xiaoxin.acp_client.Base.BaseFragment;
import com.xiaoxin.acp_client.Base.Commadapter.CommonRcvAdapter;
import com.xiaoxin.acp_client.Base.Commadapter.item.AdapterItem;
import com.xiaoxin.acp_client.R;
import com.xiaoxin.acp_client.Utils.RI;
import com.xiaoxin.acp_client.Utils.Testdata;
import com.xiaoxin.acp_client.View.TagGroup;

import java.util.List;

public class PluginListFragment extends BaseFragment {

    RecyclerView recyclerView;
    TagGroup mTagGroup;

    public PluginListFragment() {
    }

    @Override
    public View InflateView(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.fragment_plugin_list, null);
        mTagGroup = (TagGroup) inflate.findViewById(R.id.tag_group);
        recyclerView = (RecyclerView) inflate.findViewById(R.id.plugin_list);


        return inflate;
    }

    @Override
    public void InitData() {
        mTagGroup.setTags(new String[]{"工具类", "信息类", "开源类"});
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        layoutManager.setRecycleChildrenOnDetach(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter( getAdapter(RI.getdata()));

    }

    public static PluginListFragment newInstance(String param1, String param2) {
        PluginListFragment fragment = new PluginListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    private CommonRcvAdapter<Testdata> getAdapter(List<Testdata> data) {
        return new CommonRcvAdapter<Testdata>(data) {

            @Override
            public Object getItemType(Testdata demoModel) {
                return demoModel.num+"";
            }

            @NonNull
            @Override
            public AdapterItem createItem(Object type) {
                return new TextItem();
            }
        };
    }
    public class TextItem implements AdapterItem<Testdata>{
        TextView textView;
        @Override
        public int getLayoutResId() {
            return android.R.layout.simple_list_item_1;
        }

        @Override
        public void bindViews(View root) {

            textView = (TextView) root.findViewById(android.R.id.text1);
        }

        @Override
        public void setViews() {

        }

        @Override
        public void handleData(Testdata testdata, int position) {
            textView.setText("position"+testdata.num);
        }
    }

}
