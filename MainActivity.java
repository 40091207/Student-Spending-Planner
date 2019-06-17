package com.mycompany.studentspendingplanner;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.mycompany.studentspendingplanner.MESSAGE";

    DecimalFormat DecimalFormat = new DecimalFormat("#0.00");

    monthaccounts January = new monthaccounts("January", 0 , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    monthaccounts February = new monthaccounts("February", 0 , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    monthaccounts March = new monthaccounts("March", 0 , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    monthaccounts April = new monthaccounts("April", 0 , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    monthaccounts May = new monthaccounts("May", 0 , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    monthaccounts June = new monthaccounts("June", 0 , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    monthaccounts July = new monthaccounts("July", 0 , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    monthaccounts August = new monthaccounts("August", 0 , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    monthaccounts September = new monthaccounts("September", 0 , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    monthaccounts October = new monthaccounts("October", 0 , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    monthaccounts November = new monthaccounts("November", 0 , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    monthaccounts December = new monthaccounts("December", 0 , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Load();
        PopulatingTextFields();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void PopulatingTextFields()
    {
        //region populatingTextViews
        TextView textJanuary_income = (TextView) findViewById(R.id.january_income);
        textJanuary_income.setText("£" + String.valueOf(DecimalFormat.format(January.income)));
        TextView textJanuary_expenses = (TextView) findViewById(R.id.january_expenses);
        textJanuary_expenses.setText("£" + String.valueOf(DecimalFormat.format(January.expenses)));
        TextView textJanuary_total = (TextView) findViewById(R.id.january_total);
        textJanuary_total.setText("£" + String.valueOf(DecimalFormat.format(January.income - January.expenses)));
        if ((January.income - January.expenses)> 0){
            textJanuary_total.setTextColor(Color.parseColor("#FF00FF00"));
        }
        else{
            textJanuary_total.setTextColor(Color.parseColor("#FFFF0000"));

            if((January.income - January.expenses)== 0.00){
                textJanuary_total.setTextColor(Color.parseColor("#000000"));

            }
        }

        TextView textFebruary_income = (TextView) findViewById(R.id.february_income);
        textFebruary_income.setText("£" + String.valueOf(DecimalFormat.format(February.income)));
        TextView textFebruary_expenses = (TextView) findViewById(R.id.february_expenses);
        textFebruary_expenses.setText("£" + String.valueOf(DecimalFormat.format(February.expenses)));
        TextView textFebruary_total = (TextView) findViewById(R.id.february_total);
        textFebruary_total.setText("£" + String.valueOf(DecimalFormat.format(February.income - February.expenses)));
        if ((February.income - February.expenses)> 0){
            textFebruary_total.setTextColor(Color.parseColor("#FF00FF00"));
        }else{textFebruary_total.setTextColor(Color.parseColor("#FFFF0000"));
            if((February.income - February.expenses)== 0.00){
                textFebruary_total.setTextColor(Color.parseColor("#000000"));

            }}

        TextView textMarch_income = (TextView) findViewById(R.id.march_income);
        textMarch_income.setText("£" + String.valueOf(DecimalFormat.format(March.income)));
        TextView textMarch_expenses = (TextView) findViewById(R.id.march_expenses);
        textMarch_expenses.setText("£" + String.valueOf(DecimalFormat.format(March.expenses)));
        TextView textMarch_total = (TextView) findViewById(R.id.march_total);
        textMarch_total.setText("£" + String.valueOf(DecimalFormat.format(March.income-March.expenses)));
        if ((March.income - March.expenses)> 0){
            textMarch_total.setTextColor(Color.parseColor("#FF00FF00"));
        }else{textMarch_total.setTextColor(Color.parseColor("#FFFF0000"));
            if((March.income - March.expenses)== 0.00){
                textMarch_total.setTextColor(Color.parseColor("#000000"));

            }}

        TextView textApril_income = (TextView) findViewById(R.id.april_income);
        textApril_income.setText("£" + String.valueOf(DecimalFormat.format(April.income)));
        TextView textApril_expenses = (TextView) findViewById(R.id.april_expenses);
        textApril_expenses.setText("£" + String.valueOf(DecimalFormat.format(April.expenses)));
        TextView textApril_total = (TextView) findViewById(R.id.april_total);
        textApril_total.setText("£" + String.valueOf(DecimalFormat.format(April.income-April.expenses)));
        if ((April.income - April.expenses)> 0){
            textApril_total.setTextColor(Color.parseColor("#FF00FF00"));
        }else{textApril_total.setTextColor(Color.parseColor("#FFFF0000"));
            if((April.income - April.expenses)== 0.00){
                textApril_total.setTextColor(Color.parseColor("#000000"));

            }}

        TextView textMay_income = (TextView) findViewById(R.id.may_income);
        textMay_income.setText("£" + String.valueOf(DecimalFormat.format(May.income)));
        TextView textMay_expenses = (TextView) findViewById(R.id.may_expenses);
        textMay_expenses.setText("£" + String.valueOf(DecimalFormat.format(May.expenses)));
        TextView textMay_total = (TextView) findViewById(R.id.may_total);
        textMay_total.setText("£" + String.valueOf(DecimalFormat.format(May.income-May.expenses)));
        if ((May.income - May.expenses)> 0){
            textMay_total.setTextColor(Color.parseColor("#FF00FF00"));
        }else{textMay_total.setTextColor(Color.parseColor("#FFFF0000"));
            if((May.income - May.expenses)== 0.00){
                textMay_total.setTextColor(Color.parseColor("#000000"));

            }}

        TextView textJune_income = (TextView) findViewById(R.id.june_income);
        textJune_income.setText("£" + String.valueOf(DecimalFormat.format(June.income)));
        TextView textJune_expenses = (TextView) findViewById(R.id.june_expenses);
        textJune_expenses.setText("£" + String.valueOf(DecimalFormat.format(June.expenses)));
        TextView textJune_total = (TextView) findViewById(R.id.june_total);
        textJune_total.setText("£" + String.valueOf(DecimalFormat.format(June.income-June.expenses)));
        if ((June.income - June.expenses)> 0){
            textJune_total.setTextColor(Color.parseColor("#FF00FF00"));
        }else{textJune_total.setTextColor(Color.parseColor("#FFFF0000"));
            if((June.income - June.expenses)== 0.00){
                textJune_total.setTextColor(Color.parseColor("#000000"));

            }}

        TextView textJuly_income = (TextView) findViewById(R.id.july_income);
        textJuly_income.setText("£" + String.valueOf(DecimalFormat.format(July.income)));
        TextView textJuly_expenses = (TextView) findViewById(R.id.july_expenses);
        textJuly_expenses.setText("£" + String.valueOf(DecimalFormat.format(July.expenses)));
        TextView textJuly_total = (TextView) findViewById(R.id.july_total);
        textJuly_total.setText("£" + String.valueOf(DecimalFormat.format(July.income-July.expenses)));
        if ((July.income - July.expenses)> 0){
            textJuly_total.setTextColor(Color.parseColor("#FF00FF00"));
        }else{textJuly_total.setTextColor(Color.parseColor("#FFFF0000"));
            if((July.income - July.expenses)== 0.00){
                textJuly_total.setTextColor(Color.parseColor("#000000"));

            }}

        TextView textAugust_income = (TextView) findViewById(R.id.august_income);
        textAugust_income.setText("£" + String.valueOf(DecimalFormat.format(August.income)));
        TextView textAugust_expenses = (TextView) findViewById(R.id.august_expenses);
        textAugust_expenses.setText("£" + String.valueOf(DecimalFormat.format(August.expenses)));
        TextView textAugust_total = (TextView) findViewById(R.id.august_total);
        textAugust_total.setText("£" + String.valueOf(DecimalFormat.format(August.income-August.expenses)));
        if ((August.income - August.expenses)> 0){
            textAugust_total.setTextColor(Color.parseColor("#FF00FF00"));
        }else{textAugust_total.setTextColor(Color.parseColor("#FFFF0000"));
            if((August.income - August.expenses)== 0.00){
                textAugust_total.setTextColor(Color.parseColor("#000000"));

            }}

        TextView textSeptember_income = (TextView) findViewById(R.id.september_income);
        textSeptember_income.setText("£" + String.valueOf(DecimalFormat.format(September.income)));
        TextView textSeptember_expenses = (TextView) findViewById(R.id.september_expenses);
        textSeptember_expenses.setText("£" + String.valueOf(DecimalFormat.format(September.expenses)));
        TextView textSeptember_total = (TextView) findViewById(R.id.september_total);
        textSeptember_total.setText("£" + String.valueOf(DecimalFormat.format(September.income-September.expenses)));
        if ((September.income - September.expenses)> 0){
            textSeptember_total.setTextColor(Color.parseColor("#FF00FF00"));
        }else{textSeptember_total.setTextColor(Color.parseColor("#FFFF0000"));
            if((September.income - September.expenses)== 0.00){
                textSeptember_total.setTextColor(Color.parseColor("#000000"));

            }}

        TextView textOctober_income = (TextView) findViewById(R.id.october_income);
        textOctober_income.setText("£" + String.valueOf(DecimalFormat.format(October.income)));
        TextView textOctober_expenses = (TextView) findViewById(R.id.october_expenses);
        textOctober_expenses.setText("£" + String.valueOf(DecimalFormat.format(October.expenses)));
        TextView textOctober_total = (TextView) findViewById(R.id.october_total);
        textOctober_total.setText("£" + String.valueOf(DecimalFormat.format(October.income-October.expenses)));
        if ((October.income - October.expenses)> 0){
            textOctober_total.setTextColor(Color.parseColor("#FF00FF00"));
        }else{textOctober_total.setTextColor(Color.parseColor("#FFFF0000"));
            if((October.income - October.expenses)== 0.00){
                textOctober_total.setTextColor(Color.parseColor("#000000"));

            }}

        TextView textNovember_income = (TextView) findViewById(R.id.november_income);
        textNovember_income.setText("£" + String.valueOf(DecimalFormat.format(November.income)));
        TextView textNovember_expenses = (TextView) findViewById(R.id.november_expenses);
        textNovember_expenses.setText("£" + String.valueOf(DecimalFormat.format(November.expenses)));
        TextView textNovember_total = (TextView) findViewById(R.id.november_total);
        textNovember_total.setText("£" + String.valueOf(DecimalFormat.format(November.income-November.expenses)));
        if ((November.income - November.expenses)> 0){
            textNovember_total.setTextColor(Color.parseColor("#FF00FF00"));
        }else{textNovember_total.setTextColor(Color.parseColor("#FFFF0000"));
            if((November.income - November.expenses)== 0.00){
                textNovember_total.setTextColor(Color.parseColor("#000000"));

            }}

        TextView textDecember_income = (TextView) findViewById(R.id.december_income);
        textDecember_income.setText("£" + String.valueOf(DecimalFormat.format(December.income)));
        TextView textDecember_expenses = (TextView) findViewById(R.id.december_expenses);
        textDecember_expenses.setText("£" + String.valueOf(DecimalFormat.format(December.expenses)));
        TextView textDecember_total = (TextView) findViewById(R.id.december_total);
        textDecember_total.setText("£" + String.valueOf(DecimalFormat.format(December.income-December.expenses)));
        if ((December.income - November.expenses)> 0){
            textDecember_total.setTextColor(Color.parseColor("#FF00FF00"));
        }else{textDecember_total.setTextColor(Color.parseColor("#FFFF0000"));
            if((December.income - December.expenses)== 0.00){
                textDecember_total.setTextColor(Color.parseColor("#000000"));

            }}
        //endregion
    }

    public void Load()
    {

        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {


            File januaryfile = new File(getApplicationContext().getExternalFilesDir(null), "january.txt");
            File februaryfile = new File(getApplicationContext().getExternalFilesDir(null), "february.txt");
            File marchfile = new File(getApplicationContext().getExternalFilesDir(null), "march.txt");
            File aprilfile = new File(getApplicationContext().getExternalFilesDir(null), "april.txt");
            File mayfile = new File(getApplicationContext().getExternalFilesDir(null), "may.txt");
            File junefile = new File(getApplicationContext().getExternalFilesDir(null), "june.txt");
            File julyfile = new File(getApplicationContext().getExternalFilesDir(null), "july.txt");
            File augustfile = new File(getApplicationContext().getExternalFilesDir(null), "august.txt");
            File septemberfile = new File(getApplicationContext().getExternalFilesDir(null), "september.txt");
            File octoberfile = new File(getApplicationContext().getExternalFilesDir(null), "october.txt");
            File novemberfile = new File(getApplicationContext().getExternalFilesDir(null), "november.txt");
            File decemberfile = new File(getApplicationContext().getExternalFilesDir(null), "december.txt");

            //region loadmethods
            try {
                if(januaryfile.exists() && !januaryfile.isDirectory())
                {
                    InputStream januaryIs = new FileInputStream(januaryfile);
                    BufferedReader januaryBr = new BufferedReader(new InputStreamReader(januaryIs));
                    January.monthname = januaryBr.readLine();
                    January.income = Double.parseDouble(januaryBr.readLine());
                    January.expenses = Double.parseDouble(januaryBr.readLine());
                    januaryIs.close();
                }

                if(februaryfile.exists() && !februaryfile.isDirectory())
                {
                    InputStream februaryIs = new FileInputStream(februaryfile);
                    BufferedReader februaryBr = new BufferedReader(new InputStreamReader(februaryIs));
                    February.monthname = februaryBr.readLine();
                    February.income = Double.parseDouble(februaryBr.readLine());
                    February.expenses = Double.parseDouble(februaryBr.readLine());
                    februaryIs.close();
                }

                if(marchfile.exists() && !marchfile.isDirectory())
                {
                    InputStream marchIs = new FileInputStream(marchfile);
                    BufferedReader marchBr = new BufferedReader(new InputStreamReader(marchIs));
                    March.monthname = marchBr.readLine();
                    March.income = Double.parseDouble(marchBr.readLine());
                    March.expenses = Double.parseDouble(marchBr.readLine());
                    marchIs.close();
                }

                if(aprilfile.exists() && !aprilfile.isDirectory())
                {
                    InputStream aprilIs = new FileInputStream(aprilfile);
                    BufferedReader aprilBr = new BufferedReader(new InputStreamReader(aprilIs));
                    April.monthname = aprilBr.readLine();
                    April.income = Double.parseDouble(aprilBr.readLine());
                    April.expenses = Double.parseDouble(aprilBr.readLine());
                    aprilIs.close();
                }

                if(mayfile.exists() && !mayfile.isDirectory())
                {
                    InputStream mayIs = new FileInputStream(mayfile);
                    BufferedReader mayBr = new BufferedReader(new InputStreamReader(mayIs));
                    May.monthname = mayBr.readLine();
                    May.income = Double.parseDouble(mayBr.readLine());
                    May.expenses = Double.parseDouble(mayBr.readLine());
                    mayIs.close();
                }

                if(junefile.exists() && !junefile.isDirectory())
                {
                    InputStream juneIs = new FileInputStream(junefile);
                    BufferedReader juneBr = new BufferedReader(new InputStreamReader(juneIs));
                    June.monthname = juneBr.readLine();
                    June.income = Double.parseDouble(juneBr.readLine());
                    June.expenses = Double.parseDouble(juneBr.readLine());
                    juneIs.close();
                }

                if(julyfile.exists() && !julyfile.isDirectory())
                {
                    InputStream julyIs = new FileInputStream(julyfile);
                    BufferedReader julyBr = new BufferedReader(new InputStreamReader(julyIs));
                    July.monthname = julyBr.readLine();
                    July.income = Double.parseDouble(julyBr.readLine());
                    July.expenses = Double.parseDouble(julyBr.readLine());
                    julyIs.close();
                }

                if(augustfile.exists() && !augustfile.isDirectory())
                {
                    InputStream augustIs = new FileInputStream(augustfile);
                    BufferedReader augustBr = new BufferedReader(new InputStreamReader(augustIs));
                    August.monthname = augustBr.readLine();
                    August.income = Double.parseDouble(augustBr.readLine());
                    August.expenses = Double.parseDouble(augustBr.readLine());
                    augustIs.close();
                }

                if(septemberfile.exists() && !septemberfile.isDirectory())
                {
                    InputStream septemberIs = new FileInputStream(septemberfile);
                    BufferedReader septemberBr = new BufferedReader(new InputStreamReader(septemberIs));
                    September.monthname = septemberBr.readLine();
                    September.income = Double.parseDouble(septemberBr.readLine());
                    September.expenses = Double.parseDouble(septemberBr.readLine());
                    septemberIs.close();
                }

                if(octoberfile.exists() && !octoberfile.isDirectory())
                {
                    InputStream octoberIs = new FileInputStream(octoberfile);
                    BufferedReader octoberBr = new BufferedReader(new InputStreamReader(octoberIs));
                    October.monthname = octoberBr.readLine();
                    October.income = Double.parseDouble(octoberBr.readLine());
                    October.expenses = Double.parseDouble(octoberBr.readLine());
                    octoberIs.close();
                }

                if(novemberfile.exists() && !novemberfile.isDirectory())
                {
                    InputStream novemberIs = new FileInputStream(novemberfile);
                    BufferedReader novemberBr = new BufferedReader(new InputStreamReader(novemberIs));
                    November.monthname = novemberBr.readLine();
                    November.income = Double.parseDouble(novemberBr.readLine());
                    November.expenses = Double.parseDouble(novemberBr.readLine());
                    novemberIs.close();
                }

                if(decemberfile.exists() && !decemberfile.isDirectory())
                {
                    InputStream decemberIs = new FileInputStream(decemberfile);
                    BufferedReader decemberBr = new BufferedReader(new InputStreamReader(decemberIs));
                    December.monthname = decemberBr.readLine();
                    December.income = Double.parseDouble(decemberBr.readLine());
                    December.expenses = Double.parseDouble(decemberBr.readLine());
                    decemberIs.close();
                }
            } catch (IOException e) {e.printStackTrace();}
            //endregion
        }
    }

    //region labelonClicks


    public void JanuaryonClick(View v)
    {
        Intent intent = new Intent(MainActivity.this , Accounts_Editing.class);
        TextView editText = (TextView) findViewById(R.id.january_label);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void FebruaryonClick(View v)
    {
        Intent intent = new Intent(MainActivity.this , Accounts_Editing.class);
        TextView editText = (TextView) findViewById(R.id.february_label);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void MarchonClick(View v)
    {
        Intent intent = new Intent(MainActivity.this , Accounts_Editing.class);
        TextView editText = (TextView) findViewById(R.id.march_label);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void AprilonClick(View v)
    {
        Intent intent = new Intent(MainActivity.this , Accounts_Editing.class);
        TextView editText = (TextView) findViewById(R.id.april_label);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void MayonClick(View v)
    {
        Intent intent = new Intent(MainActivity.this , Accounts_Editing.class);
        TextView editText = (TextView) findViewById(R.id.may_label);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void JuneonClick(View v)
    {
        Intent intent = new Intent(MainActivity.this , Accounts_Editing.class);
        TextView editText = (TextView) findViewById(R.id.june_label);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void JulyonClick(View v)
    {
        Intent intent = new Intent(MainActivity.this , Accounts_Editing.class);
        TextView editText = (TextView) findViewById(R.id.july_label);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void AugustonClick(View v)
    {
        Intent intent = new Intent(MainActivity.this , Accounts_Editing.class);
        TextView editText = (TextView) findViewById(R.id.august_label);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void SeptemberonClick(View v)
    {
        Intent intent = new Intent(MainActivity.this , Accounts_Editing.class);
        TextView editText = (TextView) findViewById(R.id.september_label);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void OctoberonClick(View v)
    {
        Intent intent = new Intent(MainActivity.this , Accounts_Editing.class);
        TextView editText = (TextView) findViewById(R.id.october_label);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void NovemberonClick(View v)
    {
        Intent intent = new Intent(MainActivity.this , Accounts_Editing.class);
        TextView editText = (TextView) findViewById(R.id.november_label);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void DecemberonClick(View v)
    {
        Intent intent = new Intent(MainActivity.this , Accounts_Editing.class);
        TextView editText = (TextView) findViewById(R.id.december_label);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    //endregion
}

