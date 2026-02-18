public non-sealed class BRClock extends Clock {
    
    @Override
    public Clock convert(final Clock clock) {
        this.segundos = clock.getSegundos();
        this.minutos = clock.getMinutos();
        switch (clock) {
            case USAclock usaClock -> this.horas = (usaClock.getPeriodIndicator().equals("PM")) ? usaClock.getHoras() + 12 : usaClock.getHoras();
            case BRClock brClock -> this.horas = brClock.getHoras();
        }
        return this;
    }
}
