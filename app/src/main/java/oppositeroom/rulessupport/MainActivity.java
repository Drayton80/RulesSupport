package oppositeroom.rulessupport;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import oppositeroom.rulessupport.Telas.CadastroMonstro;
import oppositeroom.rulessupport.Telas.CadastroPlayer;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);


        fab.setOnClickListener(new View.OnClickListener(){
           public void onClick(View view){
               Intent it = new Intent(MainActivity.this, CadastroPlayer.class);
               startActivity(it);
           }
        });

    }

    public void monstro(View view) {
        Intent i = new Intent(this, CadastroMonstro.class);
        startActivity(i);
    }

    public void player(View view) {
        Intent i = new Intent(this, CadastroPlayer.class);
        startActivity(i);
    }

}
