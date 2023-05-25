package com.example.dev_mobile;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dev_mobile.modelo.Alimento;

public class ActivityDetalhaAlimento extends AppCompatActivity {
    private TextView tvCodigo, tvCategoria, tvAlimento, tvUmidade, tvEnergiakcal, tvKJ, tvProteinag, tvLipideosg, tvColesterolmg, tvCarboidratosg, tvFibraAlimentarg, tvCinzasg, tvCalciomg, tvMagnesiomg, tvManganesmg, tvFosforomg, tvFerromg, tvSodiomg, tvPotassiomg, tvCobremg, tvZincomg, tvRetinolmcg, tvREmcg, tvRAEmcg, tvTiaminamg, tvRiboflavinamg, tvPiridoxinamg, tvNiacinamg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalha_alimento);

        Alimento alimento = getIntent().getParcelableExtra("alimento_selecionado");

        tvCodigo = findViewById(R.id.tvCodigo);
        tvCategoria = findViewById(R.id.tvCategoria);
        tvAlimento = findViewById(R.id.tvAlimento);
        tvUmidade = findViewById(R.id.tvUmidade);
        tvEnergiakcal =  findViewById(R.id.tvEnergiakcal);
        tvKJ =  findViewById(R.id.tvKJ);
        tvProteinag =  findViewById(R.id.tvProteinag);
        tvLipideosg =  findViewById(R.id.tvLipideosg);
        tvColesterolmg =  findViewById(R.id.tvColesterolmg);
        tvCarboidratosg =  findViewById(R.id.tvCarboidratosg);
        tvFibraAlimentarg =  findViewById(R.id.tvFibraAlimentarg);
        tvCinzasg =  findViewById(R.id.tvCinzasg);
        tvCalciomg =  findViewById(R.id.tvCalciomg);
        tvMagnesiomg =  findViewById(R.id.tvMagnesiomg);
        tvManganesmg =  findViewById(R.id.tvManganesmg);
        tvFosforomg =  findViewById(R.id.tvFosforomg);
        tvFerromg =  findViewById(R.id.tvFerromg);
        tvSodiomg =  findViewById(R.id.tvSodiomg);
        tvPotassiomg =  findViewById(R.id.tvPotassiomg);
        tvCobremg =  findViewById(R.id.tvCobremg);
        tvZincomg =  findViewById(R.id.tvZincomg);
        tvRetinolmcg =  findViewById(R.id.tvRetinolmcg);
        tvREmcg =  findViewById(R.id.tvREmcg);
        tvRAEmcg =  findViewById(R.id.tvRAEmcg);
        tvTiaminamg =  findViewById(R.id.tvTiaminamg);
        tvRiboflavinamg =  findViewById(R.id.tvRiboflavinamg);
        tvPiridoxinamg =  findViewById(R.id.tvPiridoxinamg);
        tvNiacinamg =  findViewById(R.id.tvNiacinamg);

        tvCodigo.setText("Codigo: " + alimento.getId());
        tvCategoria.setText("Categoria: " + alimento.getCategoria());
        tvAlimento.setText("Alimento: " + alimento.getAlimento());
        tvUmidade.setText("Unidade: " + alimento.getUmidade());
        tvEnergiakcal.setText("Energiakcal: " + alimento.getEnergiakcal());
        tvKJ.setText("kJ: " + alimento.getkJ());
        tvProteinag.setText("Proteinag: " + alimento.getProteinag());
        tvLipideosg.setText("Lipideosg: " + alimento.getLipideosg());
        tvColesterolmg.setText("Colesterolmg: " + alimento.getColesterolmg());
        tvCarboidratosg.setText("Carboidratosg: " + alimento.getCarboidratosg());
        tvFibraAlimentarg.setText("FibraAlimentarg: " + alimento.getFibraAlimentarg());
        tvCinzasg.setText("Cinzasg: " + alimento.getCinzasg());
        tvCalciomg.setText("Calciomg: " + alimento.getCalciomg());
        tvMagnesiomg.setText("Magnesiomg: " + alimento.getMagnesiomg());
        tvManganesmg.setText("Manganesmg: " + alimento.getManganesmg());
        tvFosforomg.setText("Fosforomg: " + alimento.getFosforomg());
        tvFerromg.setText("Ferromg: " + alimento.getFerromg());
        tvSodiomg.setText("Sodiomg: " + alimento.getSodiomg());
        tvPotassiomg.setText("Potassiomg: " + alimento.getPotassiomg());
        tvCobremg.setText("Cobremg: " + alimento.getCobremg());
        tvZincomg.setText("Zincomg: " + alimento.getZincomg());
        tvRetinolmcg.setText("Retinolmcg: " + alimento.getRetinolmcg());
        tvREmcg.setText("REmcg: " + alimento.getREmcg());
        tvRAEmcg.setText("RAEmcg: " + alimento.getRAEmcg());
        tvTiaminamg.setText("Tiaminamg: " + alimento.getTiaminamg());
        tvRiboflavinamg.setText("Riboflavinamg: " + alimento.getRiboflavinamg());
        tvPiridoxinamg.setText("Piridoxinamg: " + alimento.getPiridoxinamg());
        tvNiacinamg.setText("Niacinamg: " + alimento.getNiacinamg());
    }
}
