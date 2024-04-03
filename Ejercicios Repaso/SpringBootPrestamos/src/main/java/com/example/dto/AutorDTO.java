package com.example.dto;

public class AutorDTO {
        private int idAutor;
        private String nombreAutor;
        private String pais;

        public int getIdAutor() {
            return idAutor;
        }

        public void setIdAutor(int idAutor) {
            this.idAutor = idAutor;
        }

        public String getNombreAutor() {
            return nombreAutor;
        }

        public void setNombreAutor(String nombreAutor) {
            this.nombreAutor = nombreAutor;
        }

        public String getPais() {
            return pais;
        }

        public void setPais(String pais) {
            this.pais = pais;
        }

    @Override
    public String toString() {
        return "AutorDTO{" +
                "idAutor=" + idAutor +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
