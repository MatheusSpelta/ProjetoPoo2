/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Matheus
 */

@Entity 
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "descricao_curta")
    private String descricaoCurta;
    
    @Column(name = "marca")
    private String marca;
    
    @Column(name = "quantidade")
    private Integer quantidade;
    
    @Column(name = "valor_venda")
    private BigDecimal valorVenda;
    
    @Column(name = "valor_Compra")
    private BigDecimal valorCompra;
    
    @Column(name = "ativo")
    private boolean ativo;
    
    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;
    
    //Um produto pode estar relacionado a diversas vendas, para isso existe a tabela auxiliar
    //com a qual se relaciona um para muitos.
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProdutoVenda> vendas = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "idUnidadeMedida")
    private UnidadeMedida unidadeMedida;
    
    //Setter, Getter and Constructors

    public Produto() {
    }

    public Produto(Long id, String descricaoCurta, String descricaoLonga, String marca, Integer quantidade, UnidadeMedida unidadeMedida, BigDecimal valorVenda, BigDecimal valorCompra, boolean ativo, LocalDate dataCadastro) {
        this.id = id;
        this.descricaoCurta = descricaoCurta;
        this.marca = marca;
        this.quantidade = quantidade;
        this.unidadeMedida = unidadeMedida;
        this.valorVenda = valorVenda;
        this.valorCompra = valorCompra;
        this.ativo = ativo;
        this.dataCadastro = dataCadastro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricaoCurta() {
        return descricaoCurta;
    }

    public void setDescricaoCurta(String descricaoCurta) {
        this.descricaoCurta = descricaoCurta;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<ProdutoVenda> getVendas() {
        return vendas;
    }

    public void setVendas(List<ProdutoVenda> vendas) {
        this.vendas = vendas;
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }
    
    
    
}