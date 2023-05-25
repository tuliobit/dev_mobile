package com.example.dev_mobile.modelo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Alimento implements Parcelable {
    private int id;
    private String categoria;
    private String alimento;
    private String umidade;
    private String energiakcal;
    private String kJ;
    private String proteinag;
    private String lipideosg;
    private String colesterolmg;
    private String carboidratosg;
    private String fibraAlimentarg;
    private String cinzasg;
    private String calciomg;
    private String magnesiomg;
    private String manganesmg;
    private String fosforomg;
    private String ferromg;
    private String sodiomg;
    private String potassiomg;
    private String cobremg;
    private String zincomg;
    private String retinolmcg;
    private String REmcg;
    private String RAEmcg;
    private String tiaminamg;
    private String riboflavinamg;
    private String piridoxinamg;
    private String niacinamg;
    private String vitaminaCmg;

    // Constructors, getters, and setters

    public Alimento(int id, String categoria, String alimento, String umidade, String energiakcal, String kJ, String proteinag, String lipideosg, String colesterolmg, String carboidratosg, String fibraAlimentarg, String cinzasg, String calciomg, String magnesiomg, String manganesmg, String fosforomg, String ferromg, String sodiomg, String potassiomg, String cobremg, String zincomg, String retinolmcg, String REmcg, String RAEmcg, String tiaminamg, String riboflavinamg, String piridoxinamg, String niacinamg, String vitaminaCmg) {
        this.id = id;
        this.categoria = categoria;
        this.alimento = alimento;
        this.umidade = umidade;
        this.energiakcal = energiakcal;
        this.kJ = kJ;
        this.proteinag = proteinag;
        this.lipideosg = lipideosg;
        this.colesterolmg = colesterolmg;
        this.carboidratosg = carboidratosg;
        this.fibraAlimentarg = fibraAlimentarg;
        this.cinzasg = cinzasg;
        this.calciomg = calciomg;
        this.magnesiomg = magnesiomg;
        this.manganesmg = manganesmg;
        this.fosforomg = fosforomg;
        this.ferromg = ferromg;
        this.sodiomg = sodiomg;
        this.potassiomg = potassiomg;
        this.cobremg = cobremg;
        this.zincomg = zincomg;
        this.retinolmcg = retinolmcg;
        this.REmcg = REmcg;
        this.RAEmcg = RAEmcg;
        this.tiaminamg = tiaminamg;
        this.riboflavinamg = riboflavinamg;
        this.piridoxinamg = piridoxinamg;
        this.niacinamg = niacinamg;
        this.vitaminaCmg = vitaminaCmg;
    }

    public Alimento(String categoria, String alimento, String umidade, String energiakcal, String kJ, String proteinag, String lipideosg, String colesterolmg, String carboidratosg, String fibraAlimentarg, String cinzasg, String calciomg, String magnesiomg, String manganesmg, String fosforomg, String ferromg, String sodiomg, String potassiomg, String cobremg, String zincomg, String retinolmcg, String REmcg, String RAEmcg, String tiaminamg, String riboflavinamg, String piridoxinamg, String niacinamg, String vitaminaCmg) {
        this.categoria = categoria;
        this.alimento = alimento;
        this.umidade = umidade;
        this.energiakcal = energiakcal;
        this.kJ = kJ;
        this.proteinag = proteinag;
        this.lipideosg = lipideosg;
        this.colesterolmg = colesterolmg;
        this.carboidratosg = carboidratosg;
        this.fibraAlimentarg = fibraAlimentarg;
        this.cinzasg = cinzasg;
        this.calciomg = calciomg;
        this.magnesiomg = magnesiomg;
        this.manganesmg = manganesmg;
        this.fosforomg = fosforomg;
        this.ferromg = ferromg;
        this.sodiomg = sodiomg;
        this.potassiomg = potassiomg;
        this.cobremg = cobremg;
        this.zincomg = zincomg;
        this.retinolmcg = retinolmcg;
        this.REmcg = REmcg;
        this.RAEmcg = RAEmcg;
        this.tiaminamg = tiaminamg;
        this.riboflavinamg = riboflavinamg;
        this.piridoxinamg = piridoxinamg;
        this.niacinamg = niacinamg;
        this.vitaminaCmg = vitaminaCmg;
    }

    protected Alimento(Parcel in) {
        id = in.readInt();
        categoria = in.readString();
        alimento = in.readString();
        umidade = in.readString();
        energiakcal = in.readString();
        kJ = in.readString();
        proteinag = in.readString();
        lipideosg = in.readString();
        colesterolmg = in.readString();
        carboidratosg = in.readString();
        fibraAlimentarg = in.readString();
        cinzasg = in.readString();
        calciomg = in.readString();
        magnesiomg = in.readString();
        manganesmg = in.readString();
        fosforomg = in.readString();
        ferromg = in.readString();
        sodiomg = in.readString();
        potassiomg = in.readString();
        cobremg = in.readString();
        zincomg = in.readString();
        retinolmcg = in.readString();
        REmcg = in.readString();
        RAEmcg = in.readString();
        tiaminamg = in.readString();
        riboflavinamg = in.readString();
        piridoxinamg = in.readString();
        niacinamg = in.readString();
        vitaminaCmg = in.readString();
    }

    public static final Creator<Alimento> CREATOR = new Creator<Alimento>() {
        @Override
        public Alimento createFromParcel(Parcel in) {
            return new Alimento(in);
        }

        @Override
        public Alimento[] newArray(int size) {
            return new Alimento[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }

    public String getUmidade() {
        return umidade;
    }

    public void setUmidade(String umidade) {
        this.umidade = umidade;
    }

    public String getEnergiakcal() {
        return energiakcal;
    }

    public void setEnergiakcal(String energiakcal) {
        this.energiakcal = energiakcal;
    }

    public String getkJ() {
        return kJ;
    }

    public void setkJ(String kJ) {
        this.kJ = kJ;
    }

    public String getProteinag() {
        return proteinag;
    }

    public void setProteinag(String proteinag) {
        this.proteinag = proteinag;
    }

    public String getLipideosg() {
        return lipideosg;
    }

    public void setLipideosg(String lipideosg) {
        this.lipideosg = lipideosg;
    }

    public String getColesterolmg() {
        return colesterolmg;
    }

    public void setColesterolmg(String colesterolmg) {
        this.colesterolmg = colesterolmg;
    }

    public String getCarboidratosg() {
        return carboidratosg;
    }

    public void setCarboidratosg(String carboidratosg) {
        this.carboidratosg = carboidratosg;
    }

    public String getFibraAlimentarg() {
        return fibraAlimentarg;
    }

    public void setFibraAlimentarg(String fibraAlimentarg) {
        this.fibraAlimentarg = fibraAlimentarg;
    }

    public String getCinzasg() {
        return cinzasg;
    }

    public void setCinzasg(String cinzasg) {
        this.cinzasg = cinzasg;
    }

    public String getCalciomg() {
        return calciomg;
    }

    public void setCalciomg(String calciomg) {
        this.calciomg = calciomg;
    }

    public String getMagnesiomg() {
        return magnesiomg;
    }

    public void setMagnesiomg(String magnesiomg) {
        this.magnesiomg = magnesiomg;
    }

    public String getManganesmg() {
        return manganesmg;
    }

    public void setManganesmg(String manganesmg) {
        this.manganesmg = manganesmg;
    }

    public String getFosforomg() {
        return fosforomg;
    }

    public void setFosforomg(String fosforomg) {
        this.fosforomg = fosforomg;
    }

    public String getFerromg() {
        return ferromg;
    }

    public void setFerromg(String ferromg) {
        this.ferromg = ferromg;
    }

    public String getSodiomg() {
        return sodiomg;
    }

    public void setSodiomg(String sodiomg) {
        this.sodiomg = sodiomg;
    }

    public String getPotassiomg() {
        return potassiomg;
    }

    public void setPotassiomg(String potassiomg) {
        this.potassiomg = potassiomg;
    }

    public String getCobremg() {
        return cobremg;
    }

    public void setCobremg(String cobremg) {
        this.cobremg = cobremg;
    }

    public String getZincomg() {
        return zincomg;
    }

    public void setZincomg(String zincomg) {
        this.zincomg = zincomg;
    }

    public String getRetinolmcg() {
        return retinolmcg;
    }

    public void setRetinolmcg(String retinolmcg) {
        this.retinolmcg = retinolmcg;
    }

    public String getREmcg() {
        return REmcg;
    }

    public void setREmcg(String REmcg) {
        this.REmcg = REmcg;
    }

    public String getRAEmcg() {
        return RAEmcg;
    }

    public void setRAEmcg(String RAEmcg) {
        this.RAEmcg = RAEmcg;
    }

    public String getTiaminamg() {
        return tiaminamg;
    }

    public void setTiaminamg(String tiaminamg) {
        this.tiaminamg = tiaminamg;
    }

    public String getRiboflavinamg() {
        return riboflavinamg;
    }

    public void setRiboflavinamg(String riboflavinamg) {
        this.riboflavinamg = riboflavinamg;
    }

    public String getPiridoxinamg() {
        return piridoxinamg;
    }

    public void setPiridoxinamg(String piridoxinamg) {
        this.piridoxinamg = piridoxinamg;
    }

    public String getNiacinamg() {
        return niacinamg;
    }

    public void setNiacinamg(String niacinamg) {
        this.niacinamg = niacinamg;
    }

    public String getVitaminaCmg() {
        return vitaminaCmg;
    }

    public void setVitaminaCmg(String vitaminaCmg) {
        this.vitaminaCmg = vitaminaCmg;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        //
        dest.writeInt(id);
        dest.writeString(categoria);
        dest.writeString(alimento);
        dest.writeString(umidade);
        dest.writeString(energiakcal);
        dest.writeString(kJ);
        dest.writeString(proteinag);
        dest.writeString(lipideosg);
        dest.writeString(colesterolmg);
        dest.writeString(carboidratosg);
        dest.writeString(fibraAlimentarg);
        dest.writeString(cinzasg);
        dest.writeString(calciomg);
        dest.writeString(magnesiomg);
        dest.writeString(manganesmg);
        dest.writeString(fosforomg);
        dest.writeString(ferromg);
        dest.writeString(sodiomg);
        dest.writeString(potassiomg);
        dest.writeString(cobremg);
        dest.writeString(zincomg);
        dest.writeString(retinolmcg);
        dest.writeString(REmcg);
        dest.writeString(RAEmcg);
        dest.writeString(tiaminamg);
        dest.writeString(riboflavinamg);
        dest.writeString(piridoxinamg);
        dest.writeString(niacinamg);
        dest.writeString(vitaminaCmg);
    }


}
