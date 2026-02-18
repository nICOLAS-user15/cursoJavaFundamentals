public non-sealed class USAclock extends Clock{
    private String periodIndicator;

    public String getPeriodIndicator() {
        return periodIndicator;
    }

    public void setAfterMidDay(){
        this.periodIndicator =  "PM";
    }

    public void setBeforeMidDay(){
        this.periodIndicator = "AM";
    }


    public void setHoras(int horas) {
        setBeforeMidDay();
        if (horas > 12 && (horas <= 23)){
            setAfterMidDay();
            this.horas = horas - 12;
            return;
        }else if (horas >= 24){
            this.horas = 0;
        } else 
            this.horas = horas;
    }

    @Override
    public Clock convert(Clock clock) {
        this.segundos = clock.getSegundos();
        this.minutos = clock.getMinutos();
        switch (clock){
            case USAclock usaClock ->{
                this.horas = usaClock.getHoras();
                this.periodIndicator = usaClock.getPeriodIndicator();
            }    
            case BRClock brClock -> this.setHoras(brClock.getHoras());
        }
        return this;
    }
     
    @Override
    public String getTime(){
        return super.getTime() + " " + this.periodIndicator;
    }

}
