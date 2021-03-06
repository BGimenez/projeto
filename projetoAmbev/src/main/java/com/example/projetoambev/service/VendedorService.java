package com.example.projetoambev.service;

import com.example.projetoambev.model.ResponseVendedorModel;
import com.example.projetoambev.model.VendedorModel;
import com.example.projetoambev.repository.VendedorRepository;
import com.example.projetoambev.validacoes.ValidaCPFandCNPJ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorService {

    @Autowired

    private VendedorRepository vendedorRepository;


    //Inclusao de Vendedor
    public ResponseVendedorModel salvar(VendedorModel vendedorModel)
    {
        try{

       if(vendedorRepository.existsByCPF(vendedorModel.getCPF()) || !ValidaCPFandCNPJ.isValid(vendedorModel.getCPF()))
       {
           return new ResponseVendedorModel(0,"CPF já existe ou invalido");
       }
       else
       {

           this.vendedorRepository.save(vendedorModel);
           return new ResponseVendedorModel(1,"Vendedor salvo com Sucesso");
       }



        } catch (Exception error)
        {
            return new ResponseVendedorModel(0, error.getMessage());
        }
    }

    //Alteração de um vendedor
    public ResponseVendedorModel alterar(VendedorModel vendedorModel){

        try {
            this.vendedorRepository.save(vendedorModel);
            return new ResponseVendedorModel(1,"Vendedor alterado com sucesso");

        }catch (Exception error)
        {
            return new ResponseVendedorModel(0,error.getMessage());
        }
    }

    //Consultar vendedores
    public List<VendedorModel> consultar()
    {

        return this.vendedorRepository.findAll();
    }

    //Buscar vendedor por codigo
    public Optional<VendedorModel> buscar(Long codigo)
    {
        return this.vendedorRepository.findById(codigo);
    }


    //Excluir vendedor
    public ResponseVendedorModel excluir(Long codigo){

        try{

            vendedorRepository.deleteById(codigo);
            return new ResponseVendedorModel(1,"Excluido com sucesso");

        }catch (Exception error)
        {
            return  new ResponseVendedorModel(0,error.getMessage());
        }
    }




}
