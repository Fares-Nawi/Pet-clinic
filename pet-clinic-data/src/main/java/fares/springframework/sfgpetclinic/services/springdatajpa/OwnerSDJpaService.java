package fares.springframework.sfgpetclinic.services.springdatajpa;

import fares.springframework.sfgpetclinic.model.Owner;
import fares.springframework.sfgpetclinic.repositories.OwnerRepository;
import fares.springframework.sfgpetclinic.repositories.PetRepository;
import fares.springframework.sfgpetclinic.repositories.PetTypeRepository;
import fares.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerSDJpaService( OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        Optional<Owner> ownerOptional = ownerRepository.findById(aLong);
//        if(ownerOptional.isPresent()){
//            return ownerOptional.get();
//        }
//        return null;   is the same thing bellow
        return ownerOptional.orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        System.out.println("###########");
        System.out.println("###########");
        System.out.println("###########");
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {

        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {

        ownerRepository.deleteById(aLong);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
}
