package com.example.paymybuddy;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.example.paymybuddy.repository.UserRepository;
import com.example.paymybuddy.service.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.paymybuddy.dto.TransactionDto;
import com.example.paymybuddy.model.User;
import com.example.paymybuddy.repository.TransactionRepository;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TransactionServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private AccountServiceImpl accountService;

    private User user;

    @Before
    public void setUp() {
        user = new User();
        user.setId(1L);
        user.setBankBalance("100.0");
    }

    @Test
    public void testAddUserToFriendList() {
        // À implémenter les tests pour la méthode addUserToFriendList
        // Utilisez when(userRepository.findById(userId)).thenReturn(Optional.of(user)) pour simuler la récupération de l'utilisateur
        // Utilisez verify(userRepository).save(user) pour vérifier que la méthode save est appelée correctement après la mise à jour de l'utilisateur
    }

    @Test
    public void testRemoveUserFromFriendList() {
        // À implémenter les tests pour la méthode removeUserFromFriendList
        // Utilisez when(userRepository.findById(userId)).thenReturn(Optional.of(user)) pour simuler la récupération de l'utilisateur
        // Utilisez verify(userRepository).save(user) pour vérifier que la méthode save est appelée correctement après la mise à jour de l'utilisateur
    }

    @Test
    public void testGetUserTransactions() {
        // À implémenter les tests pour la méthode getUserTransactions
        // Utilisez when(userRepository.findById(userId)).thenReturn(Optional.of(user)) pour simuler la récupération de l'utilisateur
        // Utilisez when(transactionRepository.findAllByUser(user)).thenReturn(List<Transaction>) pour simuler la récupération des transactions de l'utilisateur
        // Assurez-vous de tester les différents cas, par exemple lorsque l'utilisateur n'existe pas ou n'a pas de transactions
    }
}