package hreday.sagar.fragmenttab;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabLayout=findViewById(R.id.tabId);
        viewPager=findViewById(R.id.viewPagerId);
        viewPager.setAdapter(new pageAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    class pageAdapter extends FragmentPagerAdapter{

        String name[]={"Hreday","Sagar","Chakraborty"};




        public pageAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            if(position==0){


                return  new Hreday();
            }

            if(position==1){


                return  new Sagar();
            }
            if(position==2){


                return  new Chakraborty();
            }
            return null;
        }

        @Override
        public int getCount() {
            return name.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return  name[position];
        }
    }
}
