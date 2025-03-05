public enum Posicion {
    BASE("base"), ALERO("alero"), PIVOT("pivot");
    private String descripcion;
    Posicion(String descripcion){
        this.descripcion=descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return getDescripcion();
    }
}
