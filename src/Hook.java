import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;

public abstract class Hook implements NativeKeyListener, NativeMouseListener
{
	@Override
	public void nativeMouseClicked(NativeMouseEvent e)
	{
		
	}
	@Override
	public void nativeKeyTyped(NativeKeyEvent e)
	{
		
	}
}
