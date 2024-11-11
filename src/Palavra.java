import java.security.spec.ECFieldF2m;

public class Palavra implements Comparable<Palavra>
{
    private String texto;

    public Palavra (String texto) throws Exception
    {
		if (texto == null || texto == "")
            throw new Exception("Texto vazio");
        
        texto.trim();   // remove espaços entre a string
        this.texto = texto.toUpperCase();   // coloca a string em maiúsculo
    }

    public int getQuantidade (char letra)
    {
        int n = this.texto.length();  // obtém o tamanho da string
        int ret = 0;     // contador de quantidade de letras
        
        for(int i = 0; i < n; i++)
        {
            if(this.texto.charAt(i) == letra)   // charAt retorna a letra na posição i
                ret++;
        }
        return ret;
    }

    public int getPosicaoDaIezimaOcorrencia (int i, char letra) throws Exception
    {
        int ret = -1;  // valor de erro
        
        if(i < 0)
            throw new Exception("O valor de i não pode ser negativo!");
        
        if (this.texto.indexOf(letra) == -1)  // verifica se a letra existe na string
            throw new Exception("A palavra não possui a letra " + letra);
        
        for(int j = 0; j <= i; j++)  // loop para encontrar a ocorrência
        {
            // para a primeira ocorrência ou qualquer subsequente
            ret = this.texto.indexOf(letra, ret + 1);  // a busca começa depois da última posição encontrada

            if (ret == -1)
                throw new Exception("A palavra não possui " + (i + 1) + "ocorrências da letra" + letra);
        }
        return ret;
    }

    public int getTamanho ()
    {
        return this.texto.length();
    }

    public String toString ()
    {
        return this.texto;
    }

    public boolean equals (Object obj)
    {
        if(obj == this) return true;
        if(obj == null) return false;
        if(obj.getClass() != this.getClass()) return false;

        Palavra p = (Palavra)obj;
        int comparacao = this.texto.compareTo(p.texto);

        if(comparacao == 0)
            return true;
        else
            return false;
    }

    public int hashCode ()
    {
        int ret = 1;
        if(this.texto != null)
            ret = ret * 7 + this.texto.hashCode();
        
        if(ret < 0) ret = -ret;
        return ret;
    }

    public int compareTo (Palavra palavra)
    {
        return this.texto.compareTo(palavra.texto);
    }
}
