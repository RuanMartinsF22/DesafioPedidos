package DesafioPedidos;

public class Pedido {

        private String id;
        private String nomeCliente;
        private String descricao;
        private double valor;
        private boolean pago;
        private boolean concluido;

        public Pedido(String id, String nomeCliente, String descricao, double valor) {
            this.id = id;
            this.nomeCliente = nomeCliente;
            this.descricao = descricao;
            this.valor = valor;
            this.pago = false;
            this.concluido = false;
        }

        public void fazer() {
            System.out.println("Pedido feito por: " + nomeCliente);
        }

        public void cancelar() {
            System.out.println("Pedido cancelado.");
        }

        public void atualizar(String nomeCliente, double valor) {
            this.nomeCliente = nomeCliente;
            this.valor = valor;
            System.out.println("Pedido atualizado.");
        }

        public void concluir() {
            this.concluido = true;
            System.out.println("Pedido concluído.");
        }

        public void registrarPagamento() {
            this.pago = true;
            System.out.println("Pagamento registrado.");
        }

        // Getters and Setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNomeCliente() {
            return nomeCliente;
        }

        public void setNomeCliente(String nomeCliente) {
            this.nomeCliente = nomeCliente;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public double getValor() {
            return valor;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }

        public boolean isPago() {
            return pago;
        }

        public void setPago(boolean pago) {
            this.pago = pago;
        }

        public boolean isConcluido() {
            return concluido;
        }

        public void setConcluido(boolean concluido) {
            this.concluido = concluido;

    }
}




