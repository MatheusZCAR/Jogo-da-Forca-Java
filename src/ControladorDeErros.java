public class ControladorDeErros implements Cloneable
{
    private int qtdMax, qtdErr=0;

    public ControladorDeErros (int qtdMax) throws Exception
    {
        if (qtdMax<0) throw new Exception ("Quantidade invalida");
        this.qtdMax=qtdMax;
    }

    public void registreUmErro () throws Exception
    {
        if (this.qtdErr==this.qtdMax) throw new Exception ("Errou alem do maximo");
        this.qtdErr++;
    }

    public boolean isAtingidoMaximoDeErros  ()
    {
        if(this.qtdErr == this.qtdMax) return true;
        else return false;
    }

    public String toString ()
    {
        return this.qtdErr + "/" + this.qtdMax;
    }

    public boolean equals (Object obj)
    {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        ControladorDeErros e = (ControladorDeErros)obj;
        
        if (e.qtdErr != this.qtdErr) return false;
        if (e.qtdMax != this.qtdMax) return false;

        return true;
    }

    public int hashCode ()
    {
        int ret = 1;

        ret = ret * 3 + Integer.hashCode(this.qtdErr);
        ret = ret * 11 + Integer.hashCode(this.qtdMax);

        if (ret < 0) ret = -ret;
        return ret;
    }

    public ControladorDeErros (ControladorDeErros c) throws Exception // construtor de cópia
    {
        if (c == null) throw new Exception("Modelo ausente");

        this.qtdMax = c.qtdMax;
        this.qtdErr = c.qtdErr;
    }

    public Object clone ()
    {
        ControladorDeErros ret = null;
        try
        {
            ret = new ControladorDeErros(this);
        }
        catch (Exception erro)
        {}
        return ret;
    }
}
