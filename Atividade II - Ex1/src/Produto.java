public class Produto {
    private String nome;
    private int quantidade;
    private float valor;

    public Produto(String nome, int qtd, float valor) {
        this.nome = nome;
        this.quantidade = qtd;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public float getValor() {
        return valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }



}
