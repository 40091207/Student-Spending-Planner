package com.mycompany.studentspendingplanner;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
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
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Accounts_Editing extends AppCompatActivity {
    java.text.DecimalFormat DecimalFormat = new DecimalFormat("#0.00");
    java.text.DecimalFormat HoursFormat = new DecimalFormat("#");


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
        setContentView(R.layout.activity_accounts__editing);


        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView myText = (TextView) this.findViewById(R.id.month_title);
        myText.setText(message);

        android.support.v7.app.ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle(message);

        Load();
        PopulateTextFields();
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
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
                    January.hours = Double.parseDouble(januaryBr.readLine());
                    January.payrate = Double.parseDouble(januaryBr.readLine());
                    January.travel = Double.parseDouble(januaryBr.readLine());
                    January.groceries = Double.parseDouble(januaryBr.readLine());
                    January.utilities = Double.parseDouble(januaryBr.readLine());
                    January.overhead = Double.parseDouble(januaryBr.readLine());
                    January.miscellaneous = Double.parseDouble(januaryBr.readLine());
                    January.insurance = Double.parseDouble(januaryBr.readLine());

                    januaryIs.close();
                }

                if(februaryfile.exists() && !februaryfile.isDirectory())
                {
                    InputStream februaryIs = new FileInputStream(februaryfile);
                    BufferedReader februaryBr = new BufferedReader(new InputStreamReader(februaryIs));
                    February.monthname = februaryBr.readLine();
                    February.income = Double.parseDouble(februaryBr.readLine());
                    February.expenses = Double.parseDouble(februaryBr.readLine());
                    February.hours = Double.parseDouble(februaryBr.readLine());
                    February.payrate = Double.parseDouble(februaryBr.readLine());
                    February.travel = Double.parseDouble(februaryBr.readLine());
                    February.groceries = Double.parseDouble(februaryBr.readLine());
                    February.utilities = Double.parseDouble(februaryBr.readLine());
                    February.overhead = Double.parseDouble(februaryBr.readLine());
                    February.miscellaneous = Double.parseDouble(februaryBr.readLine());
                    February.insurance = Double.parseDouble(februaryBr.readLine());
                    februaryIs.close();
                }

                if(marchfile.exists() && !marchfile.isDirectory())
                {
                    InputStream marchIs = new FileInputStream(marchfile);
                    BufferedReader marchBr = new BufferedReader(new InputStreamReader(marchIs));
                    March.monthname = marchBr.readLine();
                    March.income = Double.parseDouble(marchBr.readLine());
                    March.expenses = Double.parseDouble(marchBr.readLine());
                    March.hours = Double.parseDouble(marchBr.readLine());
                    March.payrate = Double.parseDouble(marchBr.readLine());
                    March.travel = Double.parseDouble(marchBr.readLine());
                    March.groceries = Double.parseDouble(marchBr.readLine());
                    March.utilities = Double.parseDouble(marchBr.readLine());
                    March.overhead = Double.parseDouble(marchBr.readLine());
                    March.miscellaneous = Double.parseDouble(marchBr.readLine());
                    March.insurance = Double.parseDouble(marchBr.readLine());
                    marchIs.close();
                }

                if(aprilfile.exists() && !aprilfile.isDirectory())
                {
                    InputStream aprilIs = new FileInputStream(aprilfile);
                    BufferedReader aprilBr = new BufferedReader(new InputStreamReader(aprilIs));
                    April.monthname = aprilBr.readLine();
                    April.income = Double.parseDouble(aprilBr.readLine());
                    April.expenses = Double.parseDouble(aprilBr.readLine());
                    April.hours = Double.parseDouble(aprilBr.readLine());
                    April.payrate = Double.parseDouble(aprilBr.readLine());
                    April.travel = Double.parseDouble(aprilBr.readLine());
                    April.groceries = Double.parseDouble(aprilBr.readLine());
                    April.utilities = Double.parseDouble(aprilBr.readLine());
                    April.overhead = Double.parseDouble(aprilBr.readLine());
                    April.miscellaneous = Double.parseDouble(aprilBr.readLine());
                    April.insurance = Double.parseDouble(aprilBr.readLine());
                    aprilIs.close();
                }

                if(mayfile.exists() && !mayfile.isDirectory())
                {
                    InputStream mayIs = new FileInputStream(mayfile);
                    BufferedReader mayBr = new BufferedReader(new InputStreamReader(mayIs));
                    May.monthname = mayBr.readLine();
                    May.income = Double.parseDouble(mayBr.readLine());
                    May.expenses = Double.parseDouble(mayBr.readLine());
                    May.hours = Double.parseDouble(mayBr.readLine());
                    May.payrate = Double.parseDouble(mayBr.readLine());
                    May.travel = Double.parseDouble(mayBr.readLine());
                    May.groceries = Double.parseDouble(mayBr.readLine());
                    May.utilities = Double.parseDouble(mayBr.readLine());
                    May.overhead = Double.parseDouble(mayBr.readLine());
                    May.miscellaneous = Double.parseDouble(mayBr.readLine());
                    May.insurance = Double.parseDouble(mayBr.readLine());
                    mayIs.close();
                }

                if(junefile.exists() && !junefile.isDirectory())
                {
                    InputStream juneIs = new FileInputStream(junefile);
                    BufferedReader juneBr = new BufferedReader(new InputStreamReader(juneIs));
                    June.monthname = juneBr.readLine();
                    June.income = Double.parseDouble(juneBr.readLine());
                    June.expenses = Double.parseDouble(juneBr.readLine());
                    June.hours = Double.parseDouble(juneBr.readLine());
                    June.payrate = Double.parseDouble(juneBr.readLine());
                    June.travel = Double.parseDouble(juneBr.readLine());
                    June.groceries = Double.parseDouble(juneBr.readLine());
                    June.utilities = Double.parseDouble(juneBr.readLine());
                    June.overhead = Double.parseDouble(juneBr.readLine());
                    June.miscellaneous = Double.parseDouble(juneBr.readLine());
                    June.insurance = Double.parseDouble(juneBr.readLine());
                    juneIs.close();
                }

                if(julyfile.exists() && !julyfile.isDirectory())
                {
                    InputStream julyIs = new FileInputStream(julyfile);
                    BufferedReader julyBr = new BufferedReader(new InputStreamReader(julyIs));
                    July.monthname = julyBr.readLine();
                    July.income = Double.parseDouble(julyBr.readLine());
                    July.expenses = Double.parseDouble(julyBr.readLine());
                    July.hours = Double.parseDouble(julyBr.readLine());
                    July.payrate = Double.parseDouble(julyBr.readLine());
                    July.travel = Double.parseDouble(julyBr.readLine());
                    July.groceries = Double.parseDouble(julyBr.readLine());
                    July.utilities = Double.parseDouble(julyBr.readLine());
                    July.overhead = Double.parseDouble(julyBr.readLine());
                    July.miscellaneous = Double.parseDouble(julyBr.readLine());
                    July.insurance = Double.parseDouble(julyBr.readLine());
                    julyIs.close();
                }

                if(augustfile.exists() && !augustfile.isDirectory())
                {
                    InputStream augustIs = new FileInputStream(augustfile);
                    BufferedReader augustBr = new BufferedReader(new InputStreamReader(augustIs));
                    August.monthname = augustBr.readLine();
                    August.income = Double.parseDouble(augustBr.readLine());
                    August.expenses = Double.parseDouble(augustBr.readLine());
                    August.hours = Double.parseDouble(augustBr.readLine());
                    August.payrate = Double.parseDouble(augustBr.readLine());
                    August.travel = Double.parseDouble(augustBr.readLine());
                    August.groceries = Double.parseDouble(augustBr.readLine());
                    August.utilities = Double.parseDouble(augustBr.readLine());
                    August.overhead = Double.parseDouble(augustBr.readLine());
                    August.miscellaneous = Double.parseDouble(augustBr.readLine());
                    August.insurance = Double.parseDouble(augustBr.readLine());
                    augustIs.close();
                }

                if(septemberfile.exists() && !septemberfile.isDirectory())
                {
                    InputStream septemberIs = new FileInputStream(septemberfile);
                    BufferedReader septemberBr = new BufferedReader(new InputStreamReader(septemberIs));
                    September.monthname = septemberBr.readLine();
                    September.income = Double.parseDouble(septemberBr.readLine());
                    September.expenses = Double.parseDouble(septemberBr.readLine());
                    September.hours = Double.parseDouble(septemberBr.readLine());
                    September.payrate = Double.parseDouble(septemberBr.readLine());
                    September.travel = Double.parseDouble(septemberBr.readLine());
                    September.groceries = Double.parseDouble(septemberBr.readLine());
                    September.utilities = Double.parseDouble(septemberBr.readLine());
                    September.overhead = Double.parseDouble(septemberBr.readLine());
                    September.miscellaneous = Double.parseDouble(septemberBr.readLine());
                    September.insurance = Double.parseDouble(septemberBr.readLine());
                    septemberIs.close();
                }

                if(octoberfile.exists() && !octoberfile.isDirectory())
                {
                    InputStream octoberIs = new FileInputStream(octoberfile);
                    BufferedReader octoberBr = new BufferedReader(new InputStreamReader(octoberIs));
                    October.monthname = octoberBr.readLine();
                    October.income = Double.parseDouble(octoberBr.readLine());
                    October.expenses = Double.parseDouble(octoberBr.readLine());
                    October.hours = Double.parseDouble(octoberBr.readLine());
                    October.payrate = Double.parseDouble(octoberBr.readLine());
                    October.travel = Double.parseDouble(octoberBr.readLine());
                    October.groceries = Double.parseDouble(octoberBr.readLine());
                    October.utilities = Double.parseDouble(octoberBr.readLine());
                    October.overhead = Double.parseDouble(octoberBr.readLine());
                    October.miscellaneous = Double.parseDouble(octoberBr.readLine());
                    October.insurance = Double.parseDouble(octoberBr.readLine());
                    octoberIs.close();
                }

                if(novemberfile.exists() && !novemberfile.isDirectory())
                {
                    InputStream novemberIs = new FileInputStream(novemberfile);
                    BufferedReader novemberBr = new BufferedReader(new InputStreamReader(novemberIs));
                    November.monthname = novemberBr.readLine();
                    November.income = Double.parseDouble(novemberBr.readLine());
                    November.expenses = Double.parseDouble(novemberBr.readLine());
                    November.hours = Double.parseDouble(novemberBr.readLine());
                    November.payrate = Double.parseDouble(novemberBr.readLine());
                    November.travel = Double.parseDouble(novemberBr.readLine());
                    November.groceries = Double.parseDouble(novemberBr.readLine());
                    November.utilities = Double.parseDouble(novemberBr.readLine());
                    November.overhead = Double.parseDouble(novemberBr.readLine());
                    November.miscellaneous = Double.parseDouble(novemberBr.readLine());
                    November.insurance = Double.parseDouble(novemberBr.readLine());
                    novemberIs.close();
                }

                if(decemberfile.exists() && !decemberfile.isDirectory())
                {
                    InputStream decemberIs = new FileInputStream(decemberfile);
                    BufferedReader decemberBr = new BufferedReader(new InputStreamReader(decemberIs));
                    December.monthname = decemberBr.readLine();
                    December.income = Double.parseDouble(decemberBr.readLine());
                    December.expenses = Double.parseDouble(decemberBr.readLine());
                    December.hours = Double.parseDouble(decemberBr.readLine());
                    December.payrate = Double.parseDouble(decemberBr.readLine());
                    December.travel = Double.parseDouble(decemberBr.readLine());
                    December.groceries = Double.parseDouble(decemberBr.readLine());
                    December.utilities = Double.parseDouble(decemberBr.readLine());
                    December.overhead = Double.parseDouble(decemberBr.readLine());
                    December.miscellaneous = Double.parseDouble(decemberBr.readLine());
                    December.insurance = Double.parseDouble(decemberBr.readLine());
                    decemberIs.close();
                }
            } catch (IOException e) {e.printStackTrace();}
            //endregion
        }
    }

    public void IndividualMonthSave()
    {
        //region Gettextfromtextbox
        TextView editText = (TextView) findViewById(R.id.month_title);
        String message = editText.getText().toString().toLowerCase();

        TextView traveleditText = (TextView) findViewById(R.id.travel_editText);
        String travelstring = traveleditText.getText().toString();
        travelstring = travelstring.replaceAll("£", "");

        TextView grocerieseditText = (TextView) findViewById(R.id.groceries_editText);
        String groceriesstring = grocerieseditText.getText().toString();
        groceriesstring = groceriesstring.replaceAll("£", "");

        TextView utilitieseditText = (TextView) findViewById(R.id.utilities_editText);
        String utilitiesstring = utilitieseditText.getText().toString();
        utilitiesstring = utilitiesstring.replaceAll("£", "");

        TextView overheadseditText = (TextView) findViewById(R.id.overhead_editText);
        String overheadsstring = overheadseditText.getText().toString();
        overheadsstring = overheadsstring.replaceAll("£", "");

        TextView phonecontracteditText = (TextView) findViewById(R.id.phonecontract_editText);
        String phonecontractstring = phonecontracteditText.getText().toString();
        phonecontractstring = phonecontractstring.replaceAll("£", "");

        TextView miscellaneouseditText = (TextView) findViewById(R.id.miscellaneous_editText);
        String miscellaneousstring = miscellaneouseditText.getText().toString();
        miscellaneousstring = miscellaneousstring.replaceAll("£", "");

        TextView insuranceeditText = (TextView) findViewById(R.id.insurance_editText);
        String insurancestring = insuranceeditText.getText().toString();
        insurancestring = insurancestring.replaceAll("£", "");

        TextView loaneditText = (TextView) findViewById(R.id.loan_editText);
        String loanstring = loaneditText.getText().toString();
        loanstring = loanstring.replaceAll("£", "");

        TextView hourseditText = (TextView) findViewById(R.id.Hours_editText);
        String hoursstring = hourseditText.getText().toString();
        hoursstring = hoursstring.replaceAll("£", "");

        TextView payrateeditText = (TextView) findViewById(R.id.PayRate_editText);
        String payratestring = payrateeditText.getText().toString();
        payratestring = payratestring.replaceAll("£", "");
        //endregion

        //region JanuarySave
        if (message.equals("january")){
            double travelint = Double.parseDouble(travelstring);
            January.travel = travelint;
            January.groceries = Double.parseDouble(groceriesstring);
            January.utilities = Double.parseDouble(utilitiesstring);
            January.overhead = Double.parseDouble(overheadsstring);
            January.phonecontract = Double.parseDouble(phonecontractstring);
            January.miscellaneous = Double.parseDouble(miscellaneousstring);
            January.insurance = Double.parseDouble(insurancestring);
            January.loan = Double.parseDouble(loanstring);
            January.hours = Double.parseDouble(hoursstring);
            January.payrate = Double.parseDouble(payratestring);
            January.setExpenses();
            January.setIncome();
            January.setIncomedifference();
            FullSave();
            Intent intent = new Intent(Accounts_Editing.this , MainActivity.class);
            startActivity(intent);
        }
        //endregion
        //region FebruarySave
        if (message.equals("february"))
        {
            double travelint = Double.parseDouble(travelstring);
            February.travel = travelint;
            February.groceries = Double.parseDouble(groceriesstring);
            February.utilities = Double.parseDouble(utilitiesstring);
            February.overhead = Double.parseDouble(overheadsstring);
            February.phonecontract = Double.parseDouble(phonecontractstring);
            February.miscellaneous = Double.parseDouble(miscellaneousstring);
            February.insurance = Double.parseDouble(insurancestring);
            February.loan = Double.parseDouble(loanstring);
            February.hours = Double.parseDouble(hoursstring);
            February.payrate = Double.parseDouble(payratestring);
            February.setExpenses();
            February.setIncome();
            February.setIncomedifference();
            FullSave();
            Intent intent = new Intent(Accounts_Editing.this , MainActivity.class);
            startActivity(intent);
        }
        //endregion
        //region MarchSave
        if (message.equals("march"))
        {
            double travelint = Double.parseDouble(travelstring);
            March.travel = travelint;
            March.groceries = Double.parseDouble(groceriesstring);
            March.utilities = Double.parseDouble(utilitiesstring);
            March.overhead = Double.parseDouble(overheadsstring);
            March.phonecontract = Double.parseDouble(phonecontractstring);
            March.miscellaneous = Double.parseDouble(miscellaneousstring);
            March.insurance = Double.parseDouble(insurancestring);
            March.loan = Double.parseDouble(loanstring);
            March.hours = Double.parseDouble(hoursstring);
            March.payrate = Double.parseDouble(payratestring);
            March.setExpenses();
            March.setIncome();
            March.setIncomedifference();
            FullSave();
            Intent intent = new Intent(Accounts_Editing.this , MainActivity.class);
            startActivity(intent);
        }
        //endregion
        //region AprilSave
        if (message.equals("april"))
        {
            double travelint = Double.parseDouble(travelstring);
            April.travel = travelint;
            April.groceries = Double.parseDouble(groceriesstring);
            April.utilities = Double.parseDouble(utilitiesstring);
            April.overhead = Double.parseDouble(overheadsstring);
            April.phonecontract = Double.parseDouble(phonecontractstring);
            April.miscellaneous = Double.parseDouble(miscellaneousstring);
            April.insurance = Double.parseDouble(insurancestring);
            April.loan = Double.parseDouble(loanstring);
            April.hours = Double.parseDouble(hoursstring);
            April.payrate = Double.parseDouble(payratestring);
            April.setExpenses();
            April.setIncome();
            April.setIncomedifference();
            FullSave();
            Intent intent = new Intent(Accounts_Editing.this , MainActivity.class);
            startActivity(intent);
        }
        //endregion
        //region MaySave
        if (message.equals("may"))
        {
            double travelint = Double.parseDouble(travelstring);
            May.travel = travelint;
            May.groceries = Double.parseDouble(groceriesstring);
            May.utilities = Double.parseDouble(utilitiesstring);
            May.overhead = Double.parseDouble(overheadsstring);
            May.phonecontract = Double.parseDouble(phonecontractstring);
            May.miscellaneous = Double.parseDouble(miscellaneousstring);
            May.insurance = Double.parseDouble(insurancestring);
            May.loan = Double.parseDouble(loanstring);
            May.hours = Double.parseDouble(hoursstring);
            May.payrate = Double.parseDouble(payratestring);
            May.setExpenses();
            May.setIncome();
            May.setIncomedifference();
            FullSave();
            Intent intent = new Intent(Accounts_Editing.this , MainActivity.class);
            startActivity(intent);
        }
        //endregion
        //region JuneSave
        if (message.equals("june"))
        {
            double travelint = Double.parseDouble(travelstring);
            June.travel = travelint;
            June.groceries = Double.parseDouble(groceriesstring);
            June.utilities = Double.parseDouble(utilitiesstring);
            June.overhead = Double.parseDouble(overheadsstring);
            June.phonecontract = Double.parseDouble(phonecontractstring);
            June.miscellaneous = Double.parseDouble(miscellaneousstring);
            June.insurance = Double.parseDouble(insurancestring);
            June.loan = Double.parseDouble(loanstring);
            June.hours = Double.parseDouble(hoursstring);
            June.payrate = Double.parseDouble(payratestring);
            June.setExpenses();
            June.setIncome();
            June.setIncomedifference();
            FullSave();
            Intent intent = new Intent(Accounts_Editing.this , MainActivity.class);
            startActivity(intent);
        }
        //endregion
        //region JulySave
        if (message.equals("july"))
        {
            double travelint = Double.parseDouble(travelstring);
            July.travel = travelint;
            July.groceries = Double.parseDouble(groceriesstring);
            July.utilities = Double.parseDouble(utilitiesstring);
            July.overhead = Double.parseDouble(overheadsstring);
            July.phonecontract = Double.parseDouble(phonecontractstring);
            July.miscellaneous = Double.parseDouble(miscellaneousstring);
            July.insurance = Double.parseDouble(insurancestring);
            July.loan = Double.parseDouble(loanstring);
            July.hours = Double.parseDouble(hoursstring);
            July.payrate = Double.parseDouble(payratestring);
            July.setExpenses();
            July.setIncome();
            July.setIncomedifference();
            FullSave();
            Intent intent = new Intent(Accounts_Editing.this , MainActivity.class);
            startActivity(intent);
        }
        //endregion
        //region AugustSave
        if (message.equals("august"))
        {
            double travelint = Double.parseDouble(travelstring);
            August.travel = travelint;
            August.groceries = Double.parseDouble(groceriesstring);
            August.utilities = Double.parseDouble(utilitiesstring);
            August.overhead = Double.parseDouble(overheadsstring);
            August.phonecontract = Double.parseDouble(phonecontractstring);
            August.miscellaneous = Double.parseDouble(miscellaneousstring);
            August.insurance = Double.parseDouble(insurancestring);
            August.loan = Double.parseDouble(loanstring);
            August.hours = Double.parseDouble(hoursstring);
            August.payrate = Double.parseDouble(payratestring);
            August.setExpenses();
            August.setIncome();
            August.setIncomedifference();
            FullSave();
            Intent intent = new Intent(Accounts_Editing.this , MainActivity.class);
            startActivity(intent);
        }
        //endregion
        //region SeptemberSave
        if (message.equals("september"))
        {
            double travelint = Double.parseDouble(travelstring);
            September.travel = travelint;
            September.groceries = Double.parseDouble(groceriesstring);
            September.utilities = Double.parseDouble(utilitiesstring);
            September.overhead = Double.parseDouble(overheadsstring);
            September.phonecontract = Double.parseDouble(phonecontractstring);
            September.miscellaneous = Double.parseDouble(miscellaneousstring);
            September.insurance = Double.parseDouble(insurancestring);
            September.loan = Double.parseDouble(loanstring);
            September.hours = Double.parseDouble(hoursstring);
            September.payrate = Double.parseDouble(payratestring);
            September.setExpenses();
            September.setIncome();
            September.setIncomedifference();

            FullSave();

            Intent intent = new Intent(Accounts_Editing.this , MainActivity.class);
            startActivity(intent);
        }
        //endregion
        //region OctoberSave
        if (message.equals("october"))
        {
            double travelint = Double.parseDouble(travelstring);
            October.travel = travelint;
            October.groceries = Double.parseDouble(groceriesstring);
            October.utilities = Double.parseDouble(utilitiesstring);
            October.overhead = Double.parseDouble(overheadsstring);
            October.phonecontract = Double.parseDouble(phonecontractstring);
            October.miscellaneous = Double.parseDouble(miscellaneousstring);
            October.insurance = Double.parseDouble(insurancestring);
            October.loan = Double.parseDouble(loanstring);
            October.hours = Double.parseDouble(hoursstring);
            October.payrate = Double.parseDouble(payratestring);
            October.setExpenses();
            October.setIncome();
            October.setIncomedifference();

            FullSave();

            Intent intent = new Intent(Accounts_Editing.this , MainActivity.class);
            startActivity(intent);
        }
        //endregion
        //region NovemberSave
        if (message.equals("november"))
        {
            double travelint = Double.parseDouble(travelstring);
            November.travel = travelint;
            November.groceries = Double.parseDouble(groceriesstring);
            November.utilities = Double.parseDouble(utilitiesstring);
            November.overhead = Double.parseDouble(overheadsstring);
            November.phonecontract = Double.parseDouble(phonecontractstring);
            November.miscellaneous = Double.parseDouble(miscellaneousstring);
            November.insurance = Double.parseDouble(insurancestring);
            November.loan = Double.parseDouble(loanstring);
            November.hours = Double.parseDouble(hoursstring);
            November.payrate = Double.parseDouble(payratestring);
            November.setExpenses();
            November.setIncome();
            November.setIncomedifference();

            FullSave();

            Intent intent = new Intent(Accounts_Editing.this , MainActivity.class);
            startActivity(intent);
        }
        //endregion
        //region DecemberSave
        if (message.equals("december"))
        {
            double travelint = Double.parseDouble(travelstring);
            December.travel = travelint;
            December.groceries = Double.parseDouble(groceriesstring);
            December.utilities = Double.parseDouble(utilitiesstring);
            December.overhead = Double.parseDouble(overheadsstring);
            December.phonecontract = Double.parseDouble(phonecontractstring);
            December.miscellaneous = Double.parseDouble(miscellaneousstring);
            December.insurance = Double.parseDouble(insurancestring);
            December.loan = Double.parseDouble(loanstring);
            December.hours = Double.parseDouble(hoursstring);
            December.payrate = Double.parseDouble(payratestring);
            December.setExpenses();
            December.setIncome();
            December.setIncomedifference();

            FullSave();

            Intent intent = new Intent(Accounts_Editing.this , MainActivity.class);
            startActivity(intent);
        }
        //endregion
    }

    public void SaveonClick(View v)
    {
        IndividualMonthSave();
    }

    public void FullSave()
    {
        String state = Environment.getExternalStorageState();

        //region MonthStrings

        String Januaryincomestring = Double.toString(January.income);
        String Januaryexpensesstring = Double.toString(January.expenses);
        String Januaryhoursstring = Double.toString(January.hours);
        String Januarypayrate = Double.toString(January.payrate);
        String Januarytravelstring = Double.toString(January.travel);
        String Januarygroceriesstring = Double.toString(January.groceries);
        String Januaryutilitiesstring = Double.toString(January.utilities);
        String Januaryoverheadstring = Double.toString(January.overhead);
        String Januarymiscellaneousstring = Double.toString(January.miscellaneous);
        String Januaryinsurancestring = Double.toString(January.insurance);

        String Februaryincomestring = Double.toString(February.income);
        String Februaryexpensesstring = Double.toString(February.expenses);
        String Februaryhoursstring = Double.toString(February.hours);
        String Februarypayrate = Double.toString(February.payrate);
        String Februarytravelstring = Double.toString(February.travel);
        String Februarygroceriesstring = Double.toString(February.groceries);
        String Februaryutilitiesstring = Double.toString(February.utilities);
        String Februaryoverheadstring = Double.toString(February.overhead);
        String Februarymiscellaneousstring = Double.toString(February.miscellaneous);
        String Februaryinsurancestring = Double.toString(February.insurance);

        String Marchincomestring = Double.toString(March.income);
        String Marchexpensesstring = Double.toString(March.expenses);
        String Marchhoursstring = Double.toString(March.hours);
        String Marchpayrate = Double.toString(March.payrate);
        String Marchtravelstring = Double.toString(March.travel);
        String Marchgroceriesstring = Double.toString(March.groceries);
        String Marchutilitiesstring = Double.toString(March.utilities);
        String Marchoverheadstring = Double.toString(March.overhead);
        String Marchmiscellaneousstring = Double.toString(March.miscellaneous);
        String Marchinsurancestring = Double.toString(March.insurance);

        String Aprilincomestring = Double.toString(April.income);
        String Aprilexpensesstring = Double.toString(April.expenses);
        String Aprilhoursstring = Double.toString(April.hours);
        String Aprilpayrate = Double.toString(April.payrate);
        String Apriltravelstring = Double.toString(April.travel);
        String Aprilgroceriesstring = Double.toString(April.groceries);
        String Aprilutilitiesstring = Double.toString(April.utilities);
        String Apriloverheadstring = Double.toString(April.overhead);
        String Aprilmiscellaneousstring = Double.toString(April.miscellaneous);
        String Aprilinsurancestring = Double.toString(April.insurance);

        String Mayincomestring = Double.toString(May.income);
        String Mayexpensesstring = Double.toString(May.expenses);
        String Mayhoursstring = Double.toString(May.hours);
        String Maypayrate = Double.toString(May.payrate);
        String Maytravelstring = Double.toString(May.travel);
        String Maygroceriesstring = Double.toString(May.groceries);
        String Mayutilitiesstring = Double.toString(May.utilities);
        String Mayoverheadstring = Double.toString(May.overhead);
        String Maymiscellaneousstring = Double.toString(May.miscellaneous);
        String Mayinsurancestring = Double.toString(May.insurance);

        String Juneincomestring = Double.toString(June.income);
        String Juneexpensesstring = Double.toString(June.expenses);
        String Junehoursstring = Double.toString(June.hours);
        String Junepayrate = Double.toString(June.payrate);
        String Junetravelstring = Double.toString(June.travel);
        String Junegroceriesstring = Double.toString(June.groceries);
        String Juneutilitiesstring = Double.toString(June.utilities);
        String Juneoverheadstring = Double.toString(June.overhead);
        String Junemiscellaneousstring = Double.toString(June.miscellaneous);
        String Juneinsurancestring = Double.toString(June.insurance);

        String Julyincomestring = Double.toString(July.income);
        String Julyexpensesstring = Double.toString(July.expenses);
        String Julyhoursstring = Double.toString(July.hours);
        String Julypayrate = Double.toString(July.payrate);
        String Julytravelstring = Double.toString(July.travel);
        String Julygroceriesstring = Double.toString(July.groceries);
        String Julyutilitiesstring = Double.toString(July.utilities);
        String Julyoverheadstring = Double.toString(July.overhead);
        String Julymiscellaneousstring = Double.toString(July.miscellaneous);
        String Julyinsurancestring = Double.toString(July.insurance);

        String Augustincomestring = Double.toString(August.income);
        String Augustexpensesstring = Double.toString(August.expenses);
        String Augusthoursstring = Double.toString(August.hours);
        String Augustpayrate = Double.toString(August.payrate);
        String Augusttravelstring = Double.toString(August.travel);
        String Augustgroceriesstring = Double.toString(August.groceries);
        String Augustutilitiesstring = Double.toString(August.utilities);
        String Augustoverheadstring = Double.toString(August.overhead);
        String Augustmiscellaneousstring = Double.toString(August.miscellaneous);
        String Augustinsurancestring = Double.toString(August.insurance);

        String Septemberincomestring = Double.toString(September.income);
        String Septemberexpensesstring = Double.toString(September.expenses);
        String Septemberhoursstring = Double.toString(September.hours);
        String Septemberpayrate = Double.toString(September.payrate);
        String Septembertravelstring = Double.toString(September.travel);
        String Septembergroceriesstring = Double.toString(September.groceries);
        String Septemberutilitiesstring = Double.toString(September.utilities);
        String Septemberoverheadstring = Double.toString(September.overhead);
        String Septembermiscellaneousstring = Double.toString(September.miscellaneous);
        String Septemberinsurancestring = Double.toString(September.insurance);

        String Octoberincomestring = Double.toString(October.income);
        String Octoberexpensesstring = Double.toString(October.expenses);
        String Octoberhoursstring = Double.toString(October.hours);
        String Octoberpayrate = Double.toString(October.payrate);
        String Octobertravelstring = Double.toString(October.travel);
        String Octobergroceriesstring = Double.toString(October.groceries);
        String Octoberutilitiesstring = Double.toString(October.utilities);
        String Octoberoverheadstring = Double.toString(October.overhead);
        String Octobermiscellaneousstring = Double.toString(October.miscellaneous);
        String Octoberinsurancestring = Double.toString(October.insurance);

        String Novemberincomestring = Double.toString(November.income);
        String Novemberexpensesstring = Double.toString(November.expenses);
        String Novemberhoursstring = Double.toString(November.hours);
        String Novemberpayrate = Double.toString(November.payrate);
        String Novembertravelstring = Double.toString(November.travel);
        String Novembergroceriesstring = Double.toString(November.groceries);
        String Novemberutilitiesstring = Double.toString(November.utilities);
        String Novemberoverheadstring = Double.toString(November.overhead);
        String Novembermiscellaneousstring = Double.toString(November.miscellaneous);
        String Novemberinsurancestring = Double.toString(November.insurance);

        String Decemberincomestring = Double.toString(December.income);
        String Decemberexpensesstring = Double.toString(December.expenses);
        String Decemberhoursstring = Double.toString(December.hours);
        String Decemberpayrate = Double.toString(December.payrate);
        String Decembertravelstring = Double.toString(December.travel);
        String Decembergroceriesstring = Double.toString(December.groceries);
        String Decemberutilitiesstring = Double.toString(December.utilities);
        String Decemberoverheadstring = Double.toString(December.overhead);
        String Decembermiscellaneousstring = Double.toString(December.miscellaneous);
        String Decemberinsurancestring = Double.toString(December.insurance);
        //endregion

        if (Environment.MEDIA_MOUNTED.equals(state)){
            //region January Save
            File januaryfile = new File(getApplicationContext().getExternalFilesDir(null), "january.txt");
            try {
                OutputStream os = new FileOutputStream(januaryfile);
                os.write(January.monthname.getBytes());
                os.write('\n');
                os.write(Januaryincomestring.getBytes());
                os.write('\n');
                os.write(Januaryexpensesstring.getBytes());
                os.write('\n');
                os.write(Januaryhoursstring.getBytes());
                os.write('\n');
                os.write(Januarypayrate.getBytes());
                os.write('\n');
                os.write(Januarytravelstring.getBytes());
                os.write('\n');
                os.write(Januarygroceriesstring.getBytes());
                os.write('\n');
                os.write(Januaryutilitiesstring.getBytes());
                os.write('\n');
                os.write(Januaryoverheadstring.getBytes());
                os.write('\n');
                os.write(Januarymiscellaneousstring.getBytes());
                os.write('\n');
                os.write(Januaryinsurancestring.getBytes());
                os.close();
            } catch (Exception e){ e.printStackTrace();}
            //endregion
            //region February Save
            File februaryfile = new File(getApplicationContext().getExternalFilesDir(null), "february.txt");
            try {
                OutputStream os = new FileOutputStream(februaryfile);
                os.write(February.monthname.getBytes());
                os.write('\n');
                os.write(Februaryincomestring.getBytes());
                os.write('\n');
                os.write(Februaryexpensesstring.getBytes());
                os.write('\n');
                os.write(Februaryhoursstring.getBytes());
                os.write('\n');
                os.write(Februarypayrate.getBytes());
                os.write('\n');
                os.write(Februarytravelstring.getBytes());
                os.write('\n');
                os.write(Februarygroceriesstring.getBytes());
                os.write('\n');
                os.write(Februaryutilitiesstring.getBytes());
                os.write('\n');
                os.write(Februaryoverheadstring.getBytes());
                os.write('\n');
                os.write(Februarymiscellaneousstring.getBytes());
                os.write('\n');
                os.write(Februaryinsurancestring.getBytes());
                os.close();
            } catch (Exception e){ e.printStackTrace();}
            //endregion
            //region Merch Save
            File marchfile = new File(getApplicationContext().getExternalFilesDir(null), "march.txt");
            try {
                OutputStream os = new FileOutputStream(marchfile);
                os.write(March.monthname.getBytes());
                os.write('\n');
                os.write(Marchincomestring.getBytes());
                os.write('\n');
                os.write(Marchexpensesstring.getBytes());
                os.write('\n');
                os.write(Marchhoursstring.getBytes());
                os.write('\n');
                os.write(Marchpayrate.getBytes());
                os.write('\n');
                os.write(Marchtravelstring.getBytes());
                os.write('\n');
                os.write(Marchgroceriesstring.getBytes());
                os.write('\n');
                os.write(Marchutilitiesstring.getBytes());
                os.write('\n');
                os.write(Marchoverheadstring.getBytes());
                os.write('\n');
                os.write(Marchmiscellaneousstring.getBytes());
                os.write('\n');
                os.write(Marchinsurancestring.getBytes());
                os.close();
            } catch (Exception e){ e.printStackTrace();}
            //endregion
            //region AprilSave
            File aprilfile = new File(getApplicationContext().getExternalFilesDir(null), "april.txt");
            try {
                OutputStream os = new FileOutputStream(aprilfile);
                os.write(April.monthname.getBytes());
                os.write('\n');
                os.write(Aprilincomestring.getBytes());
                os.write('\n');
                os.write(Aprilexpensesstring.getBytes());
                os.write('\n');
                os.write(Aprilhoursstring.getBytes());
                os.write('\n');
                os.write(Aprilpayrate.getBytes());
                os.write('\n');
                os.write(Apriltravelstring.getBytes());
                os.write('\n');
                os.write(Aprilgroceriesstring.getBytes());
                os.write('\n');
                os.write(Aprilutilitiesstring.getBytes());
                os.write('\n');
                os.write(Apriloverheadstring.getBytes());
                os.write('\n');
                os.write(Aprilmiscellaneousstring.getBytes());
                os.write('\n');
                os.write(Aprilinsurancestring.getBytes());
                os.close();
            } catch (Exception e){ e.printStackTrace();}
            //endregion
            //region May Save
            File mayfile = new File(getApplicationContext().getExternalFilesDir(null), "may.txt");
            try {
                OutputStream os = new FileOutputStream(mayfile);
                os.write(May.monthname.getBytes());
                os.write('\n');
                os.write(Mayincomestring.getBytes());
                os.write('\n');
                os.write(Mayexpensesstring.getBytes());
                os.write('\n');
                os.write(Mayhoursstring.getBytes());
                os.write('\n');
                os.write(Maypayrate.getBytes());
                os.write('\n');
                os.write(Maytravelstring.getBytes());
                os.write('\n');
                os.write(Maygroceriesstring.getBytes());
                os.write('\n');
                os.write(Mayutilitiesstring.getBytes());
                os.write('\n');
                os.write(Mayoverheadstring.getBytes());
                os.write('\n');
                os.write(Maymiscellaneousstring.getBytes());
                os.write('\n');
                os.write(Mayinsurancestring.getBytes());
                os.close();
            } catch (Exception e){ e.printStackTrace();}
            //endregion
            //region June Save
            File junefile = new File(getApplicationContext().getExternalFilesDir(null), "june.txt");
            try {
                OutputStream os = new FileOutputStream(junefile);
                os.write(June.monthname.getBytes());
                os.write('\n');
                os.write(Juneincomestring.getBytes());
                os.write('\n');
                os.write(Juneexpensesstring.getBytes());
                os.write('\n');
                os.write(Junehoursstring.getBytes());
                os.write('\n');
                os.write(Junepayrate.getBytes());
                os.write('\n');
                os.write(Junetravelstring.getBytes());
                os.write('\n');
                os.write(Junegroceriesstring.getBytes());
                os.write('\n');
                os.write(Juneutilitiesstring.getBytes());
                os.write('\n');
                os.write(Juneoverheadstring.getBytes());
                os.write('\n');
                os.write(Junemiscellaneousstring.getBytes());
                os.write('\n');
                os.write(Juneinsurancestring.getBytes());
                os.close();
            } catch (Exception e){ e.printStackTrace();}
            //endregion
            //region July Save
            File julyfile = new File(getApplicationContext().getExternalFilesDir(null), "july.txt");
            try {
                OutputStream os = new FileOutputStream(julyfile);
                os.write(July.monthname.getBytes());
                os.write('\n');
                os.write(Julyincomestring.getBytes());
                os.write('\n');
                os.write(Julyexpensesstring.getBytes());
                os.write('\n');
                os.write(Julyhoursstring.getBytes());
                os.write('\n');
                os.write(Julypayrate.getBytes());
                os.write('\n');
                os.write(Julytravelstring.getBytes());
                os.write('\n');
                os.write(Julygroceriesstring.getBytes());
                os.write('\n');
                os.write(Julyutilitiesstring.getBytes());
                os.write('\n');
                os.write(Julyoverheadstring.getBytes());
                os.write('\n');
                os.write(Julymiscellaneousstring.getBytes());
                os.write('\n');
                os.write(Julyinsurancestring.getBytes());
                os.close();
            } catch (Exception e){ e.printStackTrace();}
            //endregion
            //region August Save
            File augustfile = new File(getApplicationContext().getExternalFilesDir(null), "august.txt");
            try {
                OutputStream os = new FileOutputStream(augustfile);
                os.write(August.monthname.getBytes());
                os.write('\n');
                os.write(Augustincomestring.getBytes());
                os.write('\n');
                os.write(Augustexpensesstring.getBytes());
                os.write('\n');
                os.write(Augusthoursstring.getBytes());
                os.write('\n');
                os.write(Augustpayrate.getBytes());
                os.write('\n');
                os.write(Augusttravelstring.getBytes());
                os.write('\n');
                os.write(Augustgroceriesstring.getBytes());
                os.write('\n');
                os.write(Augustutilitiesstring.getBytes());
                os.write('\n');
                os.write(Augustoverheadstring.getBytes());
                os.write('\n');
                os.write(Augustmiscellaneousstring.getBytes());
                os.write('\n');
                os.write(Augustinsurancestring.getBytes());
                os.close();
            } catch (Exception e){ e.printStackTrace();}
            //endregion
            //region September Save
            File septemberfile = new File(getApplicationContext().getExternalFilesDir(null), "september.txt");
            try {
                OutputStream os = new FileOutputStream(septemberfile);
                os.write(September.monthname.getBytes());
                os.write('\n');
                os.write(Septemberincomestring.getBytes());
                os.write('\n');
                os.write(Septemberexpensesstring.getBytes());
                os.write('\n');
                os.write(Septemberhoursstring.getBytes());
                os.write('\n');
                os.write(Septemberpayrate.getBytes());
                os.write('\n');
                os.write(Septembertravelstring.getBytes());
                os.write('\n');
                os.write(Septembergroceriesstring.getBytes());
                os.write('\n');
                os.write(Septemberutilitiesstring.getBytes());
                os.write('\n');
                os.write(Septemberoverheadstring.getBytes());
                os.write('\n');
                os.write(Septembermiscellaneousstring.getBytes());
                os.write('\n');
                os.write(Septemberinsurancestring.getBytes());
                os.close();
            } catch (Exception e){ e.printStackTrace();}
            //endregion
            //region September Save
            File octoberfile = new File(getApplicationContext().getExternalFilesDir(null), "october.txt");
            try {
                OutputStream os = new FileOutputStream(octoberfile);
                os.write(October.monthname.getBytes());
                os.write('\n');
                os.write(Octoberincomestring.getBytes());
                os.write('\n');
                os.write(Octoberexpensesstring.getBytes());
                os.write('\n');
                os.write(Octoberhoursstring.getBytes());
                os.write('\n');
                os.write(Octoberpayrate.getBytes());
                os.write('\n');
                os.write(Octobertravelstring.getBytes());
                os.write('\n');
                os.write(Octobergroceriesstring.getBytes());
                os.write('\n');
                os.write(Octoberutilitiesstring.getBytes());
                os.write('\n');
                os.write(Octoberoverheadstring.getBytes());
                os.write('\n');
                os.write(Octobermiscellaneousstring.getBytes());
                os.write('\n');
                os.write(Octoberinsurancestring.getBytes());
                os.close();
            } catch (Exception e){ e.printStackTrace();}
            //endregion
            //region NovemberSave
            File novemberfile = new File(getApplicationContext().getExternalFilesDir(null), "november.txt");
            try {
                OutputStream os = new FileOutputStream(novemberfile);
                os.write(November.monthname.getBytes());
                os.write('\n');
                os.write(Novemberincomestring.getBytes());
                os.write('\n');
                os.write(Novemberexpensesstring.getBytes());
                os.write('\n');
                os.write(Novemberhoursstring.getBytes());
                os.write('\n');
                os.write(Novemberpayrate.getBytes());
                os.write('\n');
                os.write(Novembertravelstring.getBytes());
                os.write('\n');
                os.write(Novembergroceriesstring.getBytes());
                os.write('\n');
                os.write(Novemberutilitiesstring.getBytes());
                os.write('\n');
                os.write(Novemberoverheadstring.getBytes());
                os.write('\n');
                os.write(Novembermiscellaneousstring.getBytes());
                os.write('\n');
                os.write(Novemberinsurancestring.getBytes());
                os.close();
            } catch (Exception e){ e.printStackTrace();}
            //endregion
            //region december save
            File decemberfile = new File(getApplicationContext().getExternalFilesDir(null), "december.txt");
            try {
                OutputStream os = new FileOutputStream(decemberfile);
                os.write(December.monthname.getBytes());
                os.write('\n');
                os.write(Decemberincomestring.getBytes());
                os.write('\n');
                os.write(Decemberexpensesstring.getBytes());
                os.write('\n');
                os.write(Decemberhoursstring.getBytes());
                os.write('\n');
                os.write(Decemberpayrate.getBytes());
                os.write('\n');
                os.write(Decembertravelstring.getBytes());
                os.write('\n');
                os.write(Decembergroceriesstring.getBytes());
                os.write('\n');
                os.write(Decemberutilitiesstring.getBytes());
                os.write('\n');
                os.write(Decemberoverheadstring.getBytes());
                os.write('\n');
                os.write(Decembermiscellaneousstring.getBytes());
                os.write('\n');
                os.write(Decemberinsurancestring.getBytes());
                os.close();
            } catch (Exception e){ e.printStackTrace();}
            //endregion
        }

    }

    public void PopulateTextFields()
    {
        TextView editText = (TextView) findViewById(R.id.month_title);
        String message = editText.getText().toString();

        //region populatingtextviews
        if ("January".equals(message)){
            EditText text_income = (EditText) findViewById(R.id.travel_editText);
            text_income.setText("£" + String.valueOf(DecimalFormat.format(January.travel)));
            EditText text_groceries = (EditText) findViewById(R.id.groceries_editText);
            text_groceries.setText("£" + String.valueOf(DecimalFormat.format(January.groceries)));
            EditText text_utilities = (EditText) findViewById(R.id.utilities_editText);
            text_utilities.setText("£" + String.valueOf(DecimalFormat.format(January.utilities)));
            EditText text_overhead = (EditText) findViewById(R.id.overhead_editText);
            text_overhead.setText("£" + String.valueOf(DecimalFormat.format(January.overhead)));
            EditText text_phonecontract = (EditText) findViewById(R.id.phonecontract_editText);
            text_phonecontract.setText("£" + String.valueOf(DecimalFormat.format(January.phonecontract)));
            EditText text_miscellaneous = (EditText) findViewById(R.id.miscellaneous_editText);
            text_miscellaneous.setText("£" + String.valueOf(DecimalFormat.format(January.miscellaneous)));
            EditText text_loan = (EditText) findViewById(R.id.loan_editText);
            text_loan.setText("£" + String.valueOf(DecimalFormat.format(January.loan)));
            EditText text_insurance = (EditText) findViewById(R.id.insurance_editText);
            text_insurance.setText("£" + String.valueOf(DecimalFormat.format(January.insurance)));
            EditText text_hours = (EditText) findViewById(R.id.Hours_editText);
            text_hours.setText(String.valueOf(HoursFormat.format(January.hours)));
            EditText text_payrate = (EditText) findViewById(R.id.PayRate_editText);
            text_payrate.setText("£" + String.valueOf(DecimalFormat.format(January.payrate)));
        }

        if ("February".equals(message)){
            EditText text_income = (EditText) findViewById(R.id.travel_editText);
            text_income.setText("£" + String.valueOf(DecimalFormat.format(February.travel)));
            EditText text_groceries = (EditText) findViewById(R.id.groceries_editText);
            text_groceries.setText("£" + String.valueOf(DecimalFormat.format(February.groceries)));
            EditText text_utilities = (EditText) findViewById(R.id.utilities_editText);
            text_utilities.setText("£" + String.valueOf(DecimalFormat.format(February.utilities)));
            EditText text_overhead = (EditText) findViewById(R.id.overhead_editText);
            text_overhead.setText("£" + String.valueOf(DecimalFormat.format(February.overhead)));
            EditText text_phonecontract = (EditText) findViewById(R.id.phonecontract_editText);
            text_phonecontract.setText("£" + String.valueOf(DecimalFormat.format(February.phonecontract)));
            EditText text_miscellaneous = (EditText) findViewById(R.id.miscellaneous_editText);
            text_miscellaneous.setText("£" + String.valueOf(DecimalFormat.format(February.miscellaneous)));
            EditText text_loan = (EditText) findViewById(R.id.loan_editText);
            text_loan.setText("£" + String.valueOf(DecimalFormat.format(February.loan)));
            EditText text_insurance = (EditText) findViewById(R.id.insurance_editText);
            text_insurance.setText("£" + String.valueOf(DecimalFormat.format(February.insurance)));
            EditText text_hours = (EditText) findViewById(R.id.Hours_editText);
            text_hours.setText(String.valueOf(HoursFormat.format(February.hours)));
            EditText text_payrate = (EditText) findViewById(R.id.PayRate_editText);
            text_payrate.setText("£" + String.valueOf(DecimalFormat.format(February.payrate)));
        }

        if ("March".equals(message)){
            EditText text_income = (EditText) findViewById(R.id.travel_editText);
            text_income.setText("£" + String.valueOf(DecimalFormat.format(March.travel)));
            EditText text_groceries = (EditText) findViewById(R.id.groceries_editText);
            text_groceries.setText("£" + String.valueOf(DecimalFormat.format(March.groceries)));
            EditText text_utilities = (EditText) findViewById(R.id.utilities_editText);
            text_utilities.setText("£" + String.valueOf(DecimalFormat.format(March.utilities)));
            EditText text_overhead = (EditText) findViewById(R.id.overhead_editText);
            text_overhead.setText("£" + String.valueOf(DecimalFormat.format(March.overhead)));
            EditText text_phonecontract = (EditText) findViewById(R.id.phonecontract_editText);
            text_phonecontract.setText("£" + String.valueOf(DecimalFormat.format(March.phonecontract)));
            EditText text_miscellaneous = (EditText) findViewById(R.id.miscellaneous_editText);
            text_miscellaneous.setText("£" + String.valueOf(DecimalFormat.format(March.miscellaneous)));
            EditText text_loan = (EditText) findViewById(R.id.loan_editText);
            text_loan.setText("£" + String.valueOf(DecimalFormat.format(March.loan)));
            EditText text_insurance = (EditText) findViewById(R.id.insurance_editText);
            text_insurance.setText("£" + String.valueOf(DecimalFormat.format(March.insurance)));
            EditText text_hours = (EditText) findViewById(R.id.Hours_editText);
            text_hours.setText(String.valueOf(HoursFormat.format(March.hours)));
            EditText text_payrate = (EditText) findViewById(R.id.PayRate_editText);
            text_payrate.setText("£" + String.valueOf(DecimalFormat.format(March.payrate)));
        }

        if ("April".equals(message)){
            EditText text_income = (EditText) findViewById(R.id.travel_editText);
            text_income.setText("£" + String.valueOf(DecimalFormat.format(April.travel)));
            EditText text_groceries = (EditText) findViewById(R.id.groceries_editText);
            text_groceries.setText("£" + String.valueOf(DecimalFormat.format(April.groceries)));
            EditText text_utilities = (EditText) findViewById(R.id.utilities_editText);
            text_utilities.setText("£" + String.valueOf(DecimalFormat.format(April.utilities)));
            EditText text_overhead = (EditText) findViewById(R.id.overhead_editText);
            text_overhead.setText("£" + String.valueOf(DecimalFormat.format(April.overhead)));
            EditText text_phonecontract = (EditText) findViewById(R.id.phonecontract_editText);
            text_phonecontract.setText("£" + String.valueOf(DecimalFormat.format(April.phonecontract)));
            EditText text_miscellaneous = (EditText) findViewById(R.id.miscellaneous_editText);
            text_miscellaneous.setText("£" + String.valueOf(DecimalFormat.format(April.miscellaneous)));
            EditText text_loan = (EditText) findViewById(R.id.loan_editText);
            text_loan.setText("£" + String.valueOf(DecimalFormat.format(April.loan)));
            EditText text_insurance = (EditText) findViewById(R.id.insurance_editText);
            text_insurance.setText("£" + String.valueOf(DecimalFormat.format(April.insurance)));
            EditText text_hours = (EditText) findViewById(R.id.Hours_editText);
            text_hours.setText(String.valueOf(HoursFormat.format(April.hours)));
            EditText text_payrate = (EditText) findViewById(R.id.PayRate_editText);
            text_payrate.setText("£" + String.valueOf(DecimalFormat.format(April.payrate)));
        }

        if ("May".equals(message)){
            EditText text_income = (EditText) findViewById(R.id.travel_editText);
            text_income.setText("£" + String.valueOf(DecimalFormat.format(May.travel)));
            EditText text_groceries = (EditText) findViewById(R.id.groceries_editText);
            text_groceries.setText("£" + String.valueOf(DecimalFormat.format(May.groceries)));
            EditText text_utilities = (EditText) findViewById(R.id.utilities_editText);
            text_utilities.setText("£" + String.valueOf(DecimalFormat.format(May.utilities)));
            EditText text_overhead = (EditText) findViewById(R.id.overhead_editText);
            text_overhead.setText("£" + String.valueOf(DecimalFormat.format(May.overhead)));
            EditText text_phonecontract = (EditText) findViewById(R.id.phonecontract_editText);
            text_phonecontract.setText("£" + String.valueOf(May.phonecontract));
            EditText text_miscellaneous = (EditText) findViewById(R.id.miscellaneous_editText);
            text_miscellaneous.setText("£" + String.valueOf(DecimalFormat.format(May.miscellaneous)));
            EditText text_loan = (EditText) findViewById(R.id.loan_editText);
            text_loan.setText("£" + String.valueOf(DecimalFormat.format(May.loan)));
            EditText text_insurance = (EditText) findViewById(R.id.insurance_editText);
            text_insurance.setText("£" + String.valueOf(DecimalFormat.format(May.insurance)));
            EditText text_hours = (EditText) findViewById(R.id.Hours_editText);
            text_hours.setText(String.valueOf(HoursFormat.format(May.hours)));
            EditText text_payrate = (EditText) findViewById(R.id.PayRate_editText);
            text_payrate.setText("£" + String.valueOf(DecimalFormat.format(May.payrate)));
        }

        if ("June".equals(message)){
            EditText text_income = (EditText) findViewById(R.id.travel_editText);
            text_income.setText("£" + String.valueOf(DecimalFormat.format(June.travel)));
            EditText text_groceries = (EditText) findViewById(R.id.groceries_editText);
            text_groceries.setText("£" + String.valueOf(DecimalFormat.format(June.groceries)));
            EditText text_utilities = (EditText) findViewById(R.id.utilities_editText);
            text_utilities.setText("£" + String.valueOf(DecimalFormat.format(June.utilities)));
            EditText text_overhead = (EditText) findViewById(R.id.overhead_editText);
            text_overhead.setText("£" + String.valueOf(DecimalFormat.format(June.overhead)));
            EditText text_phonecontract = (EditText) findViewById(R.id.phonecontract_editText);
            text_phonecontract.setText("£" + String.valueOf(DecimalFormat.format(June.phonecontract)));
            EditText text_miscellaneous = (EditText) findViewById(R.id.miscellaneous_editText);
            text_miscellaneous.setText("£" + String.valueOf(DecimalFormat.format(June.miscellaneous)));
            EditText text_loan = (EditText) findViewById(R.id.loan_editText);
            text_loan.setText("£" + String.valueOf(DecimalFormat.format(June.loan)));
            EditText text_insurance = (EditText) findViewById(R.id.insurance_editText);
            text_insurance.setText("£" + String.valueOf(DecimalFormat.format(June.insurance)));
            EditText text_hours = (EditText) findViewById(R.id.Hours_editText);
            text_hours.setText(String.valueOf(HoursFormat.format(June.hours)));
            EditText text_payrate = (EditText) findViewById(R.id.PayRate_editText);
            text_payrate.setText("£" + String.valueOf(DecimalFormat.format(June.payrate)));
        }

        if ("July".equals(message)){
            EditText text_income = (EditText) findViewById(R.id.travel_editText);
            text_income.setText("£" + String.valueOf(DecimalFormat.format(July.travel)));
            EditText text_groceries = (EditText) findViewById(R.id.groceries_editText);
            text_groceries.setText("£" + String.valueOf(DecimalFormat.format(July.groceries)));
            EditText text_utilities = (EditText) findViewById(R.id.utilities_editText);
            text_utilities.setText("£" + String.valueOf(DecimalFormat.format(July.utilities)));
            EditText text_overhead = (EditText) findViewById(R.id.overhead_editText);
            text_overhead.setText("£" + String.valueOf(DecimalFormat.format(July.overhead)));
            EditText text_phonecontract = (EditText) findViewById(R.id.phonecontract_editText);
            text_phonecontract.setText("£" + String.valueOf(DecimalFormat.format(July.phonecontract)));
            EditText text_miscellaneous = (EditText) findViewById(R.id.miscellaneous_editText);
            text_miscellaneous.setText("£" + String.valueOf(DecimalFormat.format(July.miscellaneous)));
            EditText text_loan = (EditText) findViewById(R.id.loan_editText);
            text_loan.setText("£" + String.valueOf(DecimalFormat.format(July.loan)));
            EditText text_insurance = (EditText) findViewById(R.id.insurance_editText);
            text_insurance.setText("£" + String.valueOf(DecimalFormat.format(July.insurance)));
            EditText text_hours = (EditText) findViewById(R.id.Hours_editText);
            text_hours.setText(String.valueOf(HoursFormat.format(July.hours)));
            EditText text_payrate = (EditText) findViewById(R.id.PayRate_editText);
            text_payrate.setText("£" + String.valueOf(DecimalFormat.format(July.payrate)));
        }

        if ("August".equals(message)){
            EditText text_income = (EditText) findViewById(R.id.travel_editText);
            text_income.setText("£" + String.valueOf(DecimalFormat.format(August.travel)));
            EditText text_groceries = (EditText) findViewById(R.id.groceries_editText);
            text_groceries.setText("£" + String.valueOf(DecimalFormat.format(August.groceries)));
            EditText text_utilities = (EditText) findViewById(R.id.utilities_editText);
            text_utilities.setText("£" + String.valueOf(DecimalFormat.format(August.utilities)));
            EditText text_overhead = (EditText) findViewById(R.id.overhead_editText);
            text_overhead.setText("£" + String.valueOf(DecimalFormat.format(August.overhead)));
            EditText text_phonecontract = (EditText) findViewById(R.id.phonecontract_editText);
            text_phonecontract.setText("£" + String.valueOf(DecimalFormat.format(August.phonecontract)));
            EditText text_miscellaneous = (EditText) findViewById(R.id.miscellaneous_editText);
            text_miscellaneous.setText("£" + String.valueOf(DecimalFormat.format(August.miscellaneous)));
            EditText text_loan = (EditText) findViewById(R.id.loan_editText);
            text_loan.setText("£" + String.valueOf(DecimalFormat.format(August.loan)));
            EditText text_insurance = (EditText) findViewById(R.id.insurance_editText);
            text_insurance.setText("£" + String.valueOf(DecimalFormat.format(August.insurance)));
            EditText text_hours = (EditText) findViewById(R.id.Hours_editText);
            text_hours.setText(String.valueOf(HoursFormat.format(August.hours)));
            EditText text_payrate = (EditText) findViewById(R.id.PayRate_editText);
            text_payrate.setText("£" + String.valueOf(DecimalFormat.format(August.payrate)));
        }

        if ("September".equals(message)){
            EditText text_income = (EditText) findViewById(R.id.travel_editText);
            text_income.setText("£" + String.valueOf(DecimalFormat.format(September.travel)));
            EditText text_groceries = (EditText) findViewById(R.id.groceries_editText);
            text_groceries.setText("£" + String.valueOf(DecimalFormat.format(September.groceries)));
            EditText text_utilities = (EditText) findViewById(R.id.utilities_editText);
            text_utilities.setText("£" + String.valueOf(DecimalFormat.format(September.utilities)));
            EditText text_overhead = (EditText) findViewById(R.id.overhead_editText);
            text_overhead.setText("£" + String.valueOf(DecimalFormat.format(September.overhead)));
            EditText text_phonecontract = (EditText) findViewById(R.id.phonecontract_editText);
            text_phonecontract.setText("£" + String.valueOf(DecimalFormat.format(September.phonecontract)));
            EditText text_miscellaneous = (EditText) findViewById(R.id.miscellaneous_editText);
            text_miscellaneous.setText("£" + String.valueOf(DecimalFormat.format(September.miscellaneous)));
            EditText text_loan = (EditText) findViewById(R.id.loan_editText);
            text_loan.setText("£" + String.valueOf(DecimalFormat.format(September.loan)));
            EditText text_insurance = (EditText) findViewById(R.id.insurance_editText);
            text_insurance.setText("£" + String.valueOf(DecimalFormat.format(September.insurance)));
            EditText text_hours = (EditText) findViewById(R.id.Hours_editText);
            text_hours.setText(String.valueOf(HoursFormat.format(September.hours)));
            EditText text_payrate = (EditText) findViewById(R.id.PayRate_editText);
            text_payrate.setText("£" + String.valueOf(DecimalFormat.format(September.payrate)));
        }

        if ("October".equals(message)){
            EditText text_income = (EditText) findViewById(R.id.travel_editText);
            text_income.setText("£" + String.valueOf(DecimalFormat.format(October.travel)));
            EditText text_groceries = (EditText) findViewById(R.id.groceries_editText);
            text_groceries.setText("£" + String.valueOf(DecimalFormat.format(October.groceries)));
            EditText text_utilities = (EditText) findViewById(R.id.utilities_editText);
            text_utilities.setText("£" + String.valueOf(DecimalFormat.format(October.utilities)));
            EditText text_overhead = (EditText) findViewById(R.id.overhead_editText);
            text_overhead.setText("£" + String.valueOf(DecimalFormat.format(October.overhead)));
            EditText text_phonecontract = (EditText) findViewById(R.id.phonecontract_editText);
            text_phonecontract.setText("£" + String.valueOf(DecimalFormat.format(October.phonecontract)));
            EditText text_miscellaneous = (EditText) findViewById(R.id.miscellaneous_editText);
            text_miscellaneous.setText("£" + String.valueOf(DecimalFormat.format(October.miscellaneous)));
            EditText text_loan = (EditText) findViewById(R.id.loan_editText);
            text_loan.setText("£" + String.valueOf(DecimalFormat.format(October.loan)));
            EditText text_insurance = (EditText) findViewById(R.id.insurance_editText);
            text_insurance.setText("£" + String.valueOf(DecimalFormat.format(October.insurance)));
            EditText text_hours = (EditText) findViewById(R.id.Hours_editText);
            text_hours.setText(String.valueOf(HoursFormat.format(October.hours)));
            EditText text_payrate = (EditText) findViewById(R.id.PayRate_editText);
            text_payrate.setText("£" + String.valueOf(DecimalFormat.format(October.payrate)));
        }

        if ("November".equals(message)){
            EditText text_income = (EditText) findViewById(R.id.travel_editText);
            text_income.setText("£" + String.valueOf(DecimalFormat.format(November.travel)));
            EditText text_groceries = (EditText) findViewById(R.id.groceries_editText);
            text_groceries.setText("£" + String.valueOf(DecimalFormat.format(November.groceries)));
            EditText text_utilities = (EditText) findViewById(R.id.utilities_editText);
            text_utilities.setText("£" + String.valueOf(DecimalFormat.format(November.utilities)));
            EditText text_overhead = (EditText) findViewById(R.id.overhead_editText);
            text_overhead.setText("£" + String.valueOf(DecimalFormat.format(November.overhead)));
            EditText text_phonecontract = (EditText) findViewById(R.id.phonecontract_editText);
            text_phonecontract.setText("£" + String.valueOf(DecimalFormat.format(November.phonecontract)));
            EditText text_miscellaneous = (EditText) findViewById(R.id.miscellaneous_editText);
            text_miscellaneous.setText("£" + String.valueOf(DecimalFormat.format(November.miscellaneous)));
            EditText text_loan = (EditText) findViewById(R.id.loan_editText);
            text_loan.setText("£" + String.valueOf(DecimalFormat.format(November.loan)));
            EditText text_insurance = (EditText) findViewById(R.id.insurance_editText);
            text_insurance.setText("£" + String.valueOf(DecimalFormat.format(November.insurance)));
            EditText text_hours = (EditText) findViewById(R.id.Hours_editText);
            text_hours.setText(String.valueOf(HoursFormat.format(November.hours)));
            EditText text_payrate = (EditText) findViewById(R.id.PayRate_editText);
            text_payrate.setText("£" + String.valueOf(DecimalFormat.format(November.payrate)));
        }

        if ("December".equals(message)){
            EditText text_income = (EditText) findViewById(R.id.travel_editText);
            text_income.setText("£" + String.valueOf(DecimalFormat.format(December.travel)));
            EditText text_groceries = (EditText) findViewById(R.id.groceries_editText);
            text_groceries.setText("£" + String.valueOf(DecimalFormat.format(December.groceries)));
            EditText text_utilities = (EditText) findViewById(R.id.utilities_editText);
            text_utilities.setText("£" + String.valueOf(DecimalFormat.format(December.utilities)));
            EditText text_overhead = (EditText) findViewById(R.id.overhead_editText);
            text_overhead.setText("£" + String.valueOf(DecimalFormat.format(December.overhead)));
            EditText text_phonecontract = (EditText) findViewById(R.id.phonecontract_editText);
            text_phonecontract.setText("£" + String.valueOf(DecimalFormat.format(December.phonecontract)));
            EditText text_miscellaneous = (EditText) findViewById(R.id.miscellaneous_editText);
            text_miscellaneous.setText("£" + String.valueOf(DecimalFormat.format(December.miscellaneous)));
            EditText text_loan = (EditText) findViewById(R.id.loan_editText);
            text_loan.setText("£" + String.valueOf(DecimalFormat.format(December.loan)));
            EditText text_insurance = (EditText) findViewById(R.id.insurance_editText);
            text_insurance.setText("£" + String.valueOf(DecimalFormat.format(December.insurance)));
            EditText text_hours = (EditText) findViewById(R.id.Hours_editText);
            text_hours.setText(String.valueOf(HoursFormat.format(December.hours)));
            EditText text_payrate = (EditText) findViewById(R.id.PayRate_editText);
            text_payrate.setText("£" + String.valueOf(DecimalFormat.format(December.payrate)));
        }
        //endregion
    }

    public void ResetonClick(View v)
    {
        Boolean Yes_No = false;

        TextView editText = (TextView) findViewById(R.id.month_title);
        String month = editText.getText().toString().toLowerCase();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Rest month " + month);
        builder.setMessage("Are you sure?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // Do nothing but close the dialog

                EditText text_income = (EditText) findViewById(R.id.travel_editText);
                text_income.setText("£0");
                EditText text_groceries = (EditText) findViewById(R.id.groceries_editText);
                text_groceries.setText("£0");
                EditText text_utilities = (EditText) findViewById(R.id.utilities_editText);
                text_utilities.setText("£0");
                EditText text_overhead = (EditText) findViewById(R.id.overhead_editText);
                text_overhead.setText("£0");
                EditText text_phonecontract = (EditText) findViewById(R.id.phonecontract_editText);
                text_phonecontract.setText("£0");
                EditText text_miscellaneous = (EditText) findViewById(R.id.miscellaneous_editText);
                text_miscellaneous.setText("£0");
                EditText text_loan = (EditText) findViewById(R.id.loan_editText);
                text_loan.setText("£0");
                EditText text_insurance = (EditText) findViewById(R.id.insurance_editText);
                text_insurance.setText("£0");
                EditText text_hours = (EditText) findViewById(R.id.Hours_editText);
                text_hours.setText("£0");
                EditText text_payrate = (EditText) findViewById(R.id.PayRate_editText);
                text_payrate.setText("£0");
                IndividualMonthSave();
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                // Do nothing
                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    public void DiscardonClick(View v)
    {
        Intent intent = new Intent(Accounts_Editing.this , MainActivity.class);
        startActivity(intent);
    }
}
