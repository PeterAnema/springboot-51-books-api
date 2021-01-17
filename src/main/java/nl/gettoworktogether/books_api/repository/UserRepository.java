package nl.gettoworktogether.books_api.repository;

import nl.gettoworktogether.books_api.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface UserRepository extends JpaRepository<User, String> {
}
