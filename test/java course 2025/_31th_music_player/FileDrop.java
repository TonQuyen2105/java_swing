import java.awt.dnd.*;
import java.awt.datatransfer.*;
import java.io.File;
import java.util.List;
import javax.swing.*;

public class FileDrop {
    public interface Listener {
        void filesDropped(File[] files);
    }

    public FileDrop(final java.awt.Component c, final Listener listener) {
        new DropTarget(c, DnDConstants.ACTION_COPY, new DropTargetAdapter() {
            @SuppressWarnings("unchecked")
            public void drop(DropTargetDropEvent evt) {
                try {
                    evt.acceptDrop(DnDConstants.ACTION_COPY);
                    Transferable t = evt.getTransferable();
                    List<File> droppedFiles = (List<File>) t.getTransferData(DataFlavor.javaFileListFlavor);
                    File[] files = droppedFiles.toArray(new File[0]);
                    listener.filesDropped(files);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }, true);
    }
}

