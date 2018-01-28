package sidm.com.assignment1;

import android.graphics.Canvas;

import java.util.HashMap;

public class SceneManager
{
    public static final SceneManager Instance = new SceneManager();
    private Scene m_currScene = null, m_nextScene = null;

    private HashMap<String, Scene> m_sceneMap = new HashMap<>();
    private GameView view = null;

    // TODO: Have a add scene function
    // TODO: Set next scene function
    // TODO: Update function

    public void SetGameView(GameView _view)
    {
        view = _view;
    }

    public void AddState(String sceneType, Scene newScene)
    {
        if(newScene == null)
            return;
        for(String key : m_sceneMap.keySet())
        {
            if(newScene == m_sceneMap.get(key))
                return;
        }
        if(m_currScene == null || m_nextScene == null)
        {
            m_currScene = m_nextScene = newScene;
            m_currScene.Init(view);
            EntityManager.Instance.Update();
        }
        m_sceneMap.put(sceneType, newScene);
    }

    public void SetNextState(String Scene)
    {
        for(String key : m_sceneMap.keySet())
        {
            if(Scene != key)
                continue;

            m_nextScene = m_sceneMap.get(key);
        }
    }

    public void Update()
    {
        for(String key : m_sceneMap.keySet())
        {
            if(m_currScene != m_nextScene)
            {
                m_currScene.Exit();
                m_currScene = m_nextScene;
                m_currScene.Init(view);
            }
            m_currScene.Update();
        }
    }

    public void Render(Canvas _canvas)
    {
        for(String key : m_sceneMap.keySet())
        {
            if(m_currScene != m_sceneMap.get(key))
                continue;

            m_currScene.Render(_canvas);
        }
    }

    public String GetCurrentScene()
    {
        if(m_currScene == null)
            return "INVALID";

        return m_currScene.GetName();
    }

    public void ResetCurrentState()
    {
        if(m_currScene == null)
            return;

        m_currScene.Reset();
    }
}
