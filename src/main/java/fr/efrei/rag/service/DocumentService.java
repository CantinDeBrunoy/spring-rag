package fr.efrei.rag.service;

import fr.efrei.rag.domain.Document;
import fr.efrei.rag.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    public Document createDocument(Document document) {
        return documentRepository.save(document);
    }

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public Optional<Document> getDocumentById(Long id) {
        return documentRepository.findById(id);
    }

    public Document updateDocument(Long id, Document documentDetails) {
        Document document = documentRepository.findById(id).orElseThrow(() -> new RuntimeException("Document not found"));
        document.setTitle(documentDetails.getTitle());
        document.setContentType(documentDetails.getContentType());
        return documentRepository.save(document);
    }

    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }
}
