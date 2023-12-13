import java.util.ArrayList;
import java.util.List;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String value) {
        TrieNode current = root;
        for (char c : value.toCharArray()) {
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
        }
        current.isEndOfWord = true;
    }

    public List<String> search(String prefix) {
        List<String> result = new ArrayList<>();
        TrieNode current = root;

        for (char c : prefix.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return result; // No words found for the given prefix
            }
            current = current.children.get(c);
        }

        findAllWords(current, prefix, result);
        return result;
    }

    private void findAllWords(TrieNode node, String prefix, List<String> result) {
        if (node.isEndOfWord) {
            result.add(prefix);
        }

        for (char c : node.children.keySet()) {
            findAllWords(node.children.get(c), prefix + c, result);
        }
    }
}
