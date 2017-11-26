package CircularDeps;

import java.util.HashSet;
import java.util.*;

public class CodeBase {
    private SourceFile[] sourceFiles;

    public CodeBase(SourceFile[] sourceFiles)
    {
        this.sourceFiles = sourceFiles;
    }

    public boolean hasCircularDependencies()
    {
        for (SourceFile file : this.sourceFiles) {
            HashSet<SourceFile> dependentFiles = new HashSet<>();
            if (existsCircularDependencies(file, dependentFiles)) {
                return true;
            }
        }
        return false;
    }

    Stack<SourceFile> stack = new Stack();
	ArrayList<SourceFile> visited = new ArrayList();
    
    // DFS partant de <<file>> détectant s'il existe
    // des dépendances circulaires dans les fichiers source.
    private boolean existsCircularDependencies(SourceFile file, HashSet<SourceFile> dependentFiles)
    {
    	
	    	if (isCyclic(file, dependentFiles))
	    	{
	    		return true;
	    	}

    	return false;
    }
    public boolean isCyclic(SourceFile file, HashSet<SourceFile> dependentFiles)
    {
    	if (!isVisited(visited,file))
    	{
    		stack.add(file);
        	visited.add(file);
        	for (SourceFile temp :file.getDependencies())
        	{
        		if (!isVisited(visited,temp) && isCyclic(temp,dependentFiles))
        		{
        			dependentFiles.add(file);
        			if(!verifierPresence(dependentFiles, temp))
        				dependentFiles.add(temp);
        				
        			return true;
        		}
        		else if (isInRecursion(stack,temp))
        		{
        			return true;
        		}
        	}
    	}
    	stack.remove(file);
    	return false;
    }
    
    public boolean verifierPresence(HashSet<SourceFile> dependentFiles,SourceFile file)
    {
    	for (SourceFile temp : dependentFiles)
    	{
    		if (temp.equals(file))
    			return true;	
    	}
    	return false;
    }
    
    public boolean isInRecursion(Stack<SourceFile> stack, SourceFile file)
    {
    	for(int i=0; i < stack.size() ; i++ )
    	{
    		if (stack.get(i).equals(file))
    			return true;
    	}
    	return false;
    }
    
    public boolean isVisited(ArrayList<SourceFile> liste, SourceFile file )
    {
    	for (int i = 0; i < liste.size() ; i++)
    	{
    		if (liste.get(i).equals(file))
    		{
    			return true;
    		}
    	}
    	return false;
    }
}
