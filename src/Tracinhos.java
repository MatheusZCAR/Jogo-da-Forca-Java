import java.security.spec.ECFieldF2m;

public class Tracinhos implements Cloneable
{
    private char texto [];

    public Tracinhos (int qtd) throws Exception
    {
        if(qtd < 0)
            throw new Exception("A quantidade não é positiva");

        this.texto = new char[qtd]; // instancia this.texto com um vetor com tamanho igual qtd

        for(int i = 0; i < qtd; i++)  // for para preencher o texto com underlines
            this.texto[i] = '_';
    }

    public void revele (int posicao, char letra) throws Exception
    {
        if(posicao < 0 && posicao >= this.texto.length)  // faz a validação necessária
            throw new Exception("Posição inválida!");
        
        this.texto[posicao] = letra;    // armazena a letra fornecida na posição também fornecida
    }

    public boolean isAindaComTracinhos ()
    {
        int qtd = this.texto.length;

        for(int i = 0; i < qtd; i++)  // percorre o texto e verifica se há underlines
        {
            if(this.texto[i] == '_')    // se achar um underline na posição i, retorna true
                return true;
        }

        return false;    // retorna false caso não tenha encontrado underlines no for acima
    }

    public String toString ()
    {
        StringBuilder fazString = new StringBuilder();  // classe que tem um método que constrói strings
        int qtd = this.texto.length;  // tamanho do vetor de texto

        for(int i = 0; i < qtd; i++)   // percorrer o vetor de texto
        {
            fazString.append(this.texto[i]);     // adicionando os caracteres a string

            if(i < qtd - 1)                      // adiciona espaço após cada caractere, exceto o último
                fazString.append(" "); 
        }

        return fazString.toString();    // retorna a nova string
    }

    public boolean equals (Object obj)
    {
        if(obj == this) return true;
        if(obj == null) return false;
        if(obj.getClass() != this.getClass()) return false;

        Tracinhos t = (Tracinhos)obj;

        if(this.texto.length != t.texto.length) return false;  // se não possuem o mesmo tamanho, retorna false
        
        for (int i = 0; i < this.texto.length; i++)    // percorre o vetor
        {
            if(this.texto[i] != t.texto[i]) return false;    // compara os valores do index i, se forem distintos retorna false
        }

        return true;   // depois de todas as validações, retorna true
    }

    public int hashCode ()
    {
        int ret = 1;

        for (int i = 0; i < this.texto.length; i++)  // calcula um hashcode novo para cada elemento do vetor
            ret = ret * 11 + Character.hashCode(this.texto[i]);
        
        if(ret < 0) ret = -ret;
        return ret;
    }

    public Tracinhos (Tracinhos t) throws Exception // construtor de cópia
    {
        if (t == null)
            throw new Exception("Modelo ausente");
        
        this.texto = new char [t.texto.length];  // instancia this.texto um vetor de mesmo tamanho de t.texto
        
        System.arraycopy(t.texto, 0, this.texto, 0, t.texto.length);  // método que copia o conteúdo do vetor t para o this.texto
    }

    public Object clone ()
    {
        Tracinhos ret = null;
        try
        {
            ret = new Tracinhos(this);
        }
        catch(Exception erro)
        {}
        return ret;
    }
}
