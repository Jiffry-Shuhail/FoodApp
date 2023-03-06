package com.example.foodreceipt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView bottomAppBar;
    private FloatingActionButton product;
    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomAppBar=findViewById(R.id.bottomNavigationAppBar);
        product=findViewById(R.id.product);
        product.setOnClickListener(v->{
            bottomAppBar.setSelectedItemId(R.id.placeholder);
            changeFragment(ProductFragment.class);
        });

        changeFragment(HomeFragment.class);

        bottomAppBar.setOnItemSelectedListener(item -> {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            switch (item.getItemId()) {
                case R.id.home:
                    changeFragment(HomeFragment.class);
                    return true;
                case R.id.billing:
                    changeFragment(PlaceYourCardFragment.class);
                    return true;
                case R.id.placeholder:
                    return true;
                case R.id.billInfo:
                    changeFragment(BillingInfoFragment.class);
                    return true;
                case R.id.status:
                    changeFragment(StatusFragment.class);
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar); //Ignore red line errors
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_24);
    }

    public void changeFragment(Class fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, fragment,null)
                .setReorderingAllowed(true)
                .addToBackStack(getResources().getString(R.string.home))
                .commit();
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    public void setNavigationIcon(int id){
        bottomAppBar.setSelectedItemId(id);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        System.out.println("****************************"+item.getItemId());
        switch (item.getItemId()) {
            case R.id.product:
                bottomAppBar.setSelectedItemId(R.id.placeholder);
                changeFragment(ProductFragment.class);
                break;
            case R.id.printingSetting:
                bottomAppBar.setSelectedItemId(R.id.placeholder);
                changeFragment(PrintFragment.class);
                break;
            case R.id.nav_logout:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}